package com.nhnacademy.edu.springboot.customerapi.repository;

import com.nhnacademy.edu.springboot.customerapi.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findAllByOrderById();
}
