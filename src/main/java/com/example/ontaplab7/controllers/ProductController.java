package com.example.ontaplab7.controllers;

import com.example.ontaplab7.enums.ProductStatus;
import com.example.ontaplab7.models.Product;
import com.example.ontaplab7.repositories.ProductRepository;
import com.example.ontaplab7.services.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public String showCandidateListPaging(Model model, @RequestParam("page")Optional<Integer> page, @RequestParam("size")Optional<Integer> size ){
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);
        Page<Product> productPage = productService.findAll(currentPage - 1, pageSize, "id", "asc");
        model.addAttribute("productPage", productPage);
        int totalPages = productPage.getTotalPages();
        if(totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "/admin/products";
    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        Optional<Product> product = productRepository.findById(id);

        productRepository.deleteById(id);
        return "redirect:/products";
    }


    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Optional<Product> product = productRepository.findById(id);
        model.addAttribute("product", product);
        return "/admin/editProducts";
    }
    @GetMapping("/Buy/{id}")
    public String buyPhone(HttpSession session, @PathVariable("id") long id) {
        Optional<Product> product = productRepository.findById(id);

        List<Product> lst = null;

        Object obj = session.getAttribute("cart");
        if (obj==null)
            lst= new ArrayList<>();
        else
            lst= (List<Product>) obj;
        lst.add(product.get());
        session.setAttribute("cart",lst);
        return "redirect:/products";
    }
    @GetMapping("/checkcart")
    public String checkcart(Model model,HttpSession session) {
        List<Product> products = (List<Product>) session.getAttribute("cart");
        model.addAttribute("cartproducts", products);
        return "/admin/cart.html";
    }
    @GetMapping("/Pay")
    public String Pay(Model model,HttpSession session) {
        session.removeAttribute("cart");
        return "redirect:/products";
    }


    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Validated Product product,
                             BindingResult result, Model model) {
        System.out.println(product.toString());
        product.setDescription("abc update");
        product.setManufacturer("abc update");
        product.setStatus(ProductStatus.ACTIVE);
        if (result.hasErrors()) {
            product.setId(id);
            return "update-user";
        }
        productRepository.save(product);
        return "redirect:/products";
    }
}
