package com.nhnacademy.edu.springboot.customerapi.repository;

import com.nhnacademy.edu.springboot.customerapi.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
