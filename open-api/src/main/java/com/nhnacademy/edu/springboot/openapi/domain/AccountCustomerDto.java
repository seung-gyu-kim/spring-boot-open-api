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
@AllArgsConstructor
public class AccountCustomerDto {
    private Long id;
    private String number;
    private Integer balance;
    private Customer customer;
}
