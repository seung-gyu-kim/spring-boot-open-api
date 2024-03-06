package com.nhnacademy.edu.springboot.openapi.adaptor.impl;

import com.nhnacademy.edu.springboot.openapi.adaptor.CustomerAdaptor;
import com.nhnacademy.edu.springboot.openapi.config.CustomerAdaptorProperties;
import com.nhnacademy.edu.springboot.openapi.domain.Customer;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class CustomerAdaptorImpl implements CustomerAdaptor {
    private final RestTemplate restTemplate;
    private final String customerApi;
    private final String customerIdApi;
    private static final ParameterizedTypeReference<List<Customer>> LIST_PARAMETERIZED_TYPE_REFERENCE = new ParameterizedTypeReference<>() {};

    public CustomerAdaptorImpl(RestTemplate restTemplate, CustomerAdaptorProperties customerAdaptorProperties) {
        this.restTemplate = restTemplate;
        customerApi = new StringBuilder(customerAdaptorProperties.getAddress()).append("/customers").toString();
        customerIdApi = new StringBuilder(customerAdaptorProperties.getAddress()).append("/customers/{id}").toString();
    }

    @Override
    public List<Customer> getCustomers() {
        RequestEntity<Void> requestEntity = RequestEntity.get(customerApi)
                .accept(MediaType.APPLICATION_JSON)
                .build();
        ResponseEntity<List<Customer>> exchange = restTemplate.exchange(requestEntity, LIST_PARAMETERIZED_TYPE_REFERENCE);

        if(!HttpStatus.OK.equals(exchange.getStatusCode())) throw new RuntimeException("Http Status가 OK 가 아닙니다.");
        return exchange.getBody();
    }

    @Override
    public Customer getCustomer(Long id) {
        RequestEntity<Void> requestEntity = RequestEntity.get(customerIdApi, id)
                .accept(MediaType.APPLICATION_JSON)
                .build();
        ResponseEntity<Customer> exchange = restTemplate.exchange(requestEntity, Customer.class);

        if(!HttpStatus.OK.equals(exchange.getStatusCode())) throw new RuntimeException("Http Status가 OK 가 아닙니다.");
        return exchange.getBody();
    }

    @Override
    public void createCustomer(Customer customer) {
        RequestEntity<Customer> requestEntity = RequestEntity.post(customerApi)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(customer);
        ResponseEntity<Customer> exchange = restTemplate.exchange(requestEntity, Customer.class);
        if(!HttpStatus.CREATED.equals(exchange.getStatusCode())) throw new RuntimeException("Http Status가 CREATED 가 아닙니다.");
    }
}
