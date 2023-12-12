package com.example.ontaplab7.repositories;

import com.example.ontaplab7.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}