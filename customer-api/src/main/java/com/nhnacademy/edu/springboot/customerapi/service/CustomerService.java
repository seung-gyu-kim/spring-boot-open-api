package com.nhnacademy.edu.springboot.customerapi.service;

import com.nhnacademy.edu.springboot.customerapi.domain.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers();
    Customer getCustomer(Long customerId);
}
