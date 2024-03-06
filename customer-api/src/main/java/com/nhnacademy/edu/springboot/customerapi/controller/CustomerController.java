package com.nhnacademy.edu.springboot.customerapi.controller;

import com.nhnacademy.edu.springboot.customerapi.domain.Customer;
import com.nhnacademy.edu.springboot.customerapi.exception.NotFoundCustomerException;
import com.nhnacademy.edu.springboot.customerapi.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return customerService.getCustomer(id);
    }

    @ExceptionHandler(NotFoundCustomerException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleException(NotFoundCustomerException ex) {

    }
}
