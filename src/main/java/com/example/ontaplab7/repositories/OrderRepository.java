package com.example.ontaplab7.repositories;

import com.example.ontaplab7.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}