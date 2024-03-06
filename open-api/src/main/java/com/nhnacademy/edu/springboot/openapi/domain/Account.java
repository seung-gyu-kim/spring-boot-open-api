package com.nhnacademy.edu.springboot.openapi.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
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