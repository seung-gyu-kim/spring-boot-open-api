package com.nhnacademy.edu.springboot.openapi.controller;

import com.nhnacademy.edu.springboot.openapi.domain.AccountCustomerDto;
import com.nhnacademy.edu.springboot.openapi.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/accounts")
public class AccountRestController {
    private final AccountService accountService;

    @GetMapping
    public List<AccountCustomerDto> getAccounts() {
        List<AccountCustomerDto> accounts = accountService.getAccountList();
        return accounts;
    }
}
