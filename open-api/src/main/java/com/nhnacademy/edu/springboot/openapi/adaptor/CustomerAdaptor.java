package com.nhnacademy.edu.springboot.openapi.adaptor;

import com.nhnacademy.edu.springboot.openapi.domain.Customer;

import java.util.List;

public interface CustomerAdaptor {
    List<Customer> getCustomers();

    Customer getCustomer(Long id);

    void createCustomer(Customer customer);
}
