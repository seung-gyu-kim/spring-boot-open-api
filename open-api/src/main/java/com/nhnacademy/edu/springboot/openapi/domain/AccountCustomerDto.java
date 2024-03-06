package com.nhnacademy.edu.springboot.openapi.domain;

import lombok.*;

/*
{
        "id": 1,
        "number": "111-111-01",
        "balance" : 1000000,
        "customer" : {
            "id" : 9,
            "name": "정지범"
        }
    }
 */
@Data
@NoArgsConstructor
public class AccountCustomerDto {
    private Long id;
    private String number;
    private Integer balance;
    private Customer customer;

    public static AccountCustomerDto from(Account account, Customer customer) {
        AccountCustomerDto dto = new AccountCustomerDto();
        dto.id = account.getId();
        dto.number = account.getNumber();
        dto.balance = account.getBalance();
        dto.customer = customer;
        return dto;
    }
}
