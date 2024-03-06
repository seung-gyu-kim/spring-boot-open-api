package com.nhnacademy.edu.springboot.openapi.service;

import com.nhnacademy.edu.springboot.openapi.domain.AccountCustomerDto;

import java.util.List;

public interface AccountService {
    List<AccountCustomerDto> getAccountList();
}
