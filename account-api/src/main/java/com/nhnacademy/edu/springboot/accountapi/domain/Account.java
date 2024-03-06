package com.nhnacademy.edu.springboot.accountapi.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "api_account")
public class Account {
    @Id
    private Long id;
    private String number;
    private Integer balance;
    private Integer customerId;

    public Account() {
    }

    public Account(Long id, String number, Integer balance, Integer customerId) {
        this.id = id;
        this.number = number;
        this.balance = balance;
        this.customerId = customerId;
    }
}