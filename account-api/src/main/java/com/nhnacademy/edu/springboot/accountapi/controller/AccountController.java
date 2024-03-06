package com.nhnacademy.edu.springboot.accountapi.controller;

import com.nhnacademy.edu.springboot.accountapi.domain.Account;
import com.nhnacademy.edu.springboot.accountapi.exception.AccountNotFoundException;
import com.nhnacademy.edu.springboot.accountapi.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class AccountController {
    private final AccountService accountService;

    @GetMapping("/accounts")
    public List<Account> getAccounts() {
        return accountService.getAccounts();
    }

    @GetMapping("/accounts/{id}")
    public Account getAccount(@PathVariable Long id) {
        return accountService.getAccount(id);
    }

    @ExceptionHandler(AccountNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleException(AccountNotFoundException ex) {

    }
}
