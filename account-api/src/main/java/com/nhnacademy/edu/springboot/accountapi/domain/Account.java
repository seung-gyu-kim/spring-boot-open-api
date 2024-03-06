package com.nhnacademy.edu.springboot.accountapi.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "api_account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    private Integer balance;
    private Long customerId;

    @PostPersist
    public void postPersist() {
        long tmp = 11111100 + this.id;
        this.number = String.format("%d-%03d-%02d", tmp / 100000, (tmp / 100) % 1000, tmp % 100);
    }

    public Account() {
    }

    public Account(Long id, String number, Integer balance, Long customerId) {
        this.id = id;
        this.number = number;
        this.balance = balance;
        this.customerId = customerId;
    }
}