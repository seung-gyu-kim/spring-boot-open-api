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

    public Account() {
    }

    public Account(Long id, String number, Integer balance) {
        this.id = id;
        this.number = number;
        this.balance = balance;
    }
}