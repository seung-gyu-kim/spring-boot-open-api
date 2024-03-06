package com.nhnacademy.edu.springboot.openapi.adaptor.impl;

import com.nhnacademy.edu.springboot.openapi.adaptor.AccountAdaptor;
import com.nhnacademy.edu.springboot.openapi.config.AccountAdaptorProperties;
import com.nhnacademy.edu.springboot.openapi.domain.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Slf4j
@Component
public class AccountAdaptorImpl implements AccountAdaptor {
    private final ParameterizedTypeReference<List<Account>> LIST_PARAMETERIZED_TYPE_REFERENCE;
    private final ParameterizedTypeReference<Account> ACCOUNT_PARAMETERIZED_TYPE_REFERENCE;
    private final RestTemplate restTemplate;
    private final String accountsApi;
    private final String accountIdApi;

    public AccountAdaptorImpl(RestTemplate restTemplate, AccountAdaptorProperties accountAdaptorProperties) {
        this.restTemplate = restTemplate;
        this.accountsApi = new StringBuilder(accountAdaptorProperties.getAddress()).append("/accounts").toString();
        this.accountIdApi = new StringBuilder(accountAdaptorProperties.getAddress()).append("/accounts/{id}").toString();
        LIST_PARAMETERIZED_TYPE_REFERENCE = new ParameterizedTypeReference<>() {};
        ACCOUNT_PARAMETERIZED_TYPE_REFERENCE = new ParameterizedTypeReference<>() {};
    }

    @Override
    public List<Account> getAccounts() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<List<Account>> exchange = restTemplate.exchange(accountsApi,
                HttpMethod.GET,
                requestEntity,
                LIST_PARAMETERIZED_TYPE_REFERENCE
                );
        HttpStatus statusCode = exchange.getStatusCode();
        if(!Objects.equals(statusCode, HttpStatus.OK)) {
            throw new RuntimeException("Http Status가 OK 가 아닙니다.");
        }
        return exchange.getBody();
    }

    @Override
    public Account getAccount(Long id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<Account> exchange = restTemplate.exchange(
                accountIdApi,
                HttpMethod.GET,
                requestEntity,
                ACCOUNT_PARAMETERIZED_TYPE_REFERENCE,
                id
        );
        HttpStatus statusCode = exchange.getStatusCode();
        if(!Objects.equals(statusCode, HttpStatus.OK)) {
            throw new RuntimeException("Http Status가 OK 가 아닙니다.");
        }
        return exchange.getBody();
    }

    @Override
    public void createAccount(Account account) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<Account> requestEntity = new HttpEntity<>(account, httpHeaders);
        ResponseEntity<Account> exchange = restTemplate.exchange(accountsApi,
                HttpMethod.POST,
                requestEntity,
                ACCOUNT_PARAMETERIZED_TYPE_REFERENCE);
        HttpStatus statusCode = exchange.getStatusCode();
        if(!Objects.equals(statusCode, HttpStatus.CREATED)) {
            throw new RuntimeException("Http Status가 CREATED 가 아닙니다.");
        }
    }
}
