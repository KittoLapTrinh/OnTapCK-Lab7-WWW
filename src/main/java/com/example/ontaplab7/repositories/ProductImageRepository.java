package com.example.ontaplab7.repositories;

import com.example.ontaplab7.models.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {
}