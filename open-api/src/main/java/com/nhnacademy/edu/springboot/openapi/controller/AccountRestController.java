package com.nhnacademy.edu.springboot.openapi.controller;

import com.nhnacademy.edu.springboot.openapi.domain.AccountCustomerDto;
import com.nhnacademy.edu.springboot.openapi.domain.AccountRequest;
import com.nhnacademy.edu.springboot.openapi.domain.IdResponse;
import com.nhnacademy.edu.springboot.openapi.exception.AccountNotFoundException;
import com.nhnacademy.edu.springboot.openapi.exception.ValidationFailedException;
import com.nhnacademy.edu.springboot.openapi.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import javax.validation.Valid;
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

    @PostMapping
    public ResponseEntity<IdResponse> createAccount(@Valid @RequestBody AccountRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationFailedException(bindingResult);
        }
        IdResponse idResponse = accountService.createAccount(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(idResponse);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
    }

    @ExceptionHandler({AccountNotFoundException.class, HttpClientErrorException.NotFound.class, HttpServerErrorException.InternalServerError.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleException(Exception ex) { }
}
