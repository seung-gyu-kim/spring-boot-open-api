package com.nhnacademy.edu.springboot.openapi.service.impl;

import com.nhnacademy.edu.springboot.openapi.adaptor.AccountAdaptor;
import com.nhnacademy.edu.springboot.openapi.adaptor.CustomerAdaptor;
import com.nhnacademy.edu.springboot.openapi.domain.*;
import com.nhnacademy.edu.springboot.openapi.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {
    private final AccountAdaptor accountAdaptor;
    private final CustomerAdaptor customerAdaptor;

    @Override
    public List<AccountCustomerDto> getAccountList() {
           List<Account> accounts = accountAdaptor.getAccounts();
//        accounts.sort(Comparator.comparingLong(Account::getId));
        List<Customer> customers = customerAdaptor.getCustomers();
//        customers.sort(Comparator.comparingLong(Customer::getId));

        List<AccountCustomerDto> accountCustomerDtoList = new ArrayList<>();
        for(Account account : accounts) {
            Long customerId = account.getCustomerId();
            int index = Collections.binarySearch(
                    customers, new Customer(customerId), Comparator.comparingLong(Customer::getId)
            );
            if(index >= 0) {
                AccountCustomerDto accountCustomerDto = AccountCustomerDto.from(account, customers.get(index));
                accountCustomerDtoList.add(accountCustomerDto);
            }
        }
        return accountCustomerDtoList;
    }

    @Override
    public AccountCustomerDto getAccount(Long id) {
        Account account = accountAdaptor.getAccount(id);
        Customer customer = customerAdaptor.getCustomer(account.getCustomerId());
        return AccountCustomerDto.from(account, customer);
    }

    @Override
    public IdResponse createAccount(AccountRequest accountRequest) {
        return accountAdaptor.createAccount(accountRequest);
    }
}
