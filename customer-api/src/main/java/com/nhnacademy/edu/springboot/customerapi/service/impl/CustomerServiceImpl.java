package com.nhnacademy.edu.springboot.customerapi.service.impl;

import com.nhnacademy.edu.springboot.customerapi.domain.Customer;
import com.nhnacademy.edu.springboot.customerapi.exception.CustomerNotFoundException;
import com.nhnacademy.edu.springboot.customerapi.repository.CustomerRepository;
import com.nhnacademy.edu.springboot.customerapi.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAllByOrderById();
    }

    @Override
    public Customer getCustomer(Long customerId) {
        return customerRepository.findById(customerId).orElseThrow(CustomerNotFoundException::new);
    }
}
