package com.nhnacademy.edu.springboot.openapi.adaptor;

import com.nhnacademy.edu.springboot.openapi.domain.Account;

import java.util.List;

public interface AccountAdaptor {
    List<Account> getAccounts();

    Account getAccount(Long id);

    void createAccount(Account account);
}
