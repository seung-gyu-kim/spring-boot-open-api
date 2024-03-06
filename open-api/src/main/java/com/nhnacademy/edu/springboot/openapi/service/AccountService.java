package com.nhnacademy.edu.springboot.openapi.service;

import com.nhnacademy.edu.springboot.openapi.domain.AccountCustomerDto;
import com.nhnacademy.edu.springboot.openapi.domain.AccountRequest;
import com.nhnacademy.edu.springboot.openapi.domain.IdResponse;

import java.util.List;

public interface AccountService {
    List<AccountCustomerDto> getAccountList();

    AccountCustomerDto getAccount(Long id);

    IdResponse createAccount(AccountRequest accountRequest);
}
