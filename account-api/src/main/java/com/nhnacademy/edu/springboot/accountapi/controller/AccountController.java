package com.nhnacademy.edu.springboot.accountapi.controller;

import com.nhnacademy.edu.springboot.accountapi.domain.Account;
import com.nhnacademy.edu.springboot.accountapi.domain.AccountRequest;
import com.nhnacademy.edu.springboot.accountapi.domain.IdResponse;
import com.nhnacademy.edu.springboot.accountapi.exception.AccountNotFoundException;
import com.nhnacademy.edu.springboot.accountapi.exception.ValidationFailedException;
import com.nhnacademy.edu.springboot.accountapi.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping("/accounts")
    public ResponseEntity<IdResponse> createAccount(@Valid @RequestBody AccountRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationFailedException(bindingResult);
        }
        Account save = accountService.createAccount(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(new IdResponse(save.getId()));
    }

    @DeleteMapping("/accounts/{id}")
    public void deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
    }

    @ExceptionHandler(AccountNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleException(AccountNotFoundException ex) {

    }
}
