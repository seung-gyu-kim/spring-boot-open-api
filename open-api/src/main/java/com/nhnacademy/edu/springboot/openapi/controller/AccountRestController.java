package com.nhnacademy.edu.springboot.openapi.controller;

import com.nhnacademy.edu.springboot.openapi.domain.AccountCustomerDto;
import com.nhnacademy.edu.springboot.openapi.exception.AccountNotFoundException;
import com.nhnacademy.edu.springboot.openapi.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/accounts")
public class AccountRestController {
    private final AccountService accountService;

    @GetMapping
    public List<AccountCustomerDto> getAccounts() {
        return accountService.getAccountList();
    }

    @GetMapping("/{id}")
    public AccountCustomerDto getAccount(@PathVariable Long id) {
        return accountService.getAccount(id);
    }

    @ExceptionHandler({AccountNotFoundException.class, HttpClientErrorException.NotFound.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleException(Exception ex) {

    }
}
