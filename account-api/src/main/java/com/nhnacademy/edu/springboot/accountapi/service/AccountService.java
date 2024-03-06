package com.nhnacademy.edu.springboot.accountapi.service;

import com.nhnacademy.edu.springboot.accountapi.domain.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAccounts();

    Account getAccount(Long accountId);
}
