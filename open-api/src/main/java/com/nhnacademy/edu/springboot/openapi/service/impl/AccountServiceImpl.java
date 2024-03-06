package com.nhnacademy.edu.springboot.openapi.service.impl;

import com.nhnacademy.edu.springboot.openapi.domain.AccountCustomerDto;
import com.nhnacademy.edu.springboot.openapi.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class AccountServiceImpl implements AccountService {
    @Override
    public List<AccountCustomerDto> getAccountList() {
        return null;
    }
}
