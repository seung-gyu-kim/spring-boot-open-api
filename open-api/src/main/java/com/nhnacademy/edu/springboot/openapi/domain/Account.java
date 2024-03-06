package com.nhnacademy.edu.springboot.openapi.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class Account {
    private Long id;
    private String number;
    private Integer balance;
    private Long customerId;

    public Account() {
    }
}