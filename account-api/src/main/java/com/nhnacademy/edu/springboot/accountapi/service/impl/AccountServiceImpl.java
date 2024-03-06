package com.nhnacademy.edu.springboot.accountapi.service.impl;

import com.nhnacademy.edu.springboot.accountapi.domain.Account;
import com.nhnacademy.edu.springboot.accountapi.domain.AccountRequest;
import com.nhnacademy.edu.springboot.accountapi.exception.AccountNotFoundException;
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
        return accountRepository.findAllByOrderById();
    }

    @Override
    public Account getAccount(Long accountId) {
        return accountRepository.findById(accountId).orElseThrow(AccountNotFoundException::new);
    }

    @Override
    @Transactional
    public Account createAccount(AccountRequest accountRequest) {
        Account account = new Account();
        account.setBalance(accountRequest.getBalance());
        account.setCustomerId(accountRequest.getCustomerId());
        return accountRepository.save(account);
    }
}
