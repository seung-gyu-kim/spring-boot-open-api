package com.nhnacademy.edu.springboot.accountapi.service.impl;

import com.nhnacademy.edu.springboot.accountapi.domain.Account;
import com.nhnacademy.edu.springboot.accountapi.exception.NotFoundAccountException;
import com.nhnacademy.edu.springboot.accountapi.repository.AccountRepository;
import com.nhnacademy.edu.springboot.accountapi.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Override
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account getAccount(Long accountId) {
        return accountRepository.findById(accountId).orElseThrow(NotFoundAccountException::new);
    }
}
