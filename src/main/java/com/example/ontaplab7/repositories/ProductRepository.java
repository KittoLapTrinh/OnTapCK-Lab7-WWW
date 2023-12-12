package com.example.ontaplab7.repositories;


import com.example.ontaplab7.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    public abstract void deleteById(Long id);
    public abstract Product findById(long id);
}