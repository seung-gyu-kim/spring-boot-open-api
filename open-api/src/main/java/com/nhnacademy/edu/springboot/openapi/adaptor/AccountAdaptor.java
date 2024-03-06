package com.nhnacademy.edu.springboot.openapi.adaptor;

import com.nhnacademy.edu.springboot.openapi.domain.Account;
import com.nhnacademy.edu.springboot.openapi.domain.AccountRequest;
import com.nhnacademy.edu.springboot.openapi.domain.IdResponse;

import java.util.List;

public interface AccountAdaptor {
    List<Account> getAccounts();

    Account getAccount(Long id);

    IdResponse createAccount(AccountRequest accountRequest);

    void deleteAccount(Long id);
}
