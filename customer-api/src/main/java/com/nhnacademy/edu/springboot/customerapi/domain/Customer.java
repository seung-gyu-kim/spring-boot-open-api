package com.nhnacademy.edu.springboot.customerapi.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "api_customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Customer() {
    }

    public Customer(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
