package com.example.ontaplab7.repositories;

import com.example.ontaplab7.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}