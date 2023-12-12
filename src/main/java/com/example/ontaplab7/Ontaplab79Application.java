package com.example.ontaplab7;

import com.example.ontaplab7.enums.ProductStatus;
import com.example.ontaplab7.models.Product;
import com.example.ontaplab7.repositories.ProductRepository;
import net.datafaker.Faker;
import net.datafaker.providers.base.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;


@SpringBootApplication
public class Ontaplab79Application {

    @Autowired
    ProductRepository productRepository;
    public static void main(String[] args) {
        SpringApplication.run(Ontaplab79Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            Faker faker = new Faker();
            Random rnd = new Random();
            Device devices = faker.device();
            Product product = null;
            for(int i = 0; i < 200; i++){
                product = new Product(devices.modelName(), faker.lorem().paragraph(30), "piece", devices.manufacturer(), ProductStatus.ACTIVE);
                productRepository.save(product);
            }
        };
    }

}
