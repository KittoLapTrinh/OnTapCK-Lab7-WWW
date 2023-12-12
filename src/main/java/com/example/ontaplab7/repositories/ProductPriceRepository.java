package com.example.ontaplab7.repositories;

import com.example.ontaplab7.models.ProductPrice;
import com.example.ontaplab7.pks.ProductPricePK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductPriceRepository extends JpaRepository<ProductPrice, ProductPricePK> {
}