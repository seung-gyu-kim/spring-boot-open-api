package com.nhnacademy.edu.springboot.openapi.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class Customer {
    private Long id;
    private String name;

    public Customer() {
    }

    public Customer(Long id) {
        this.id = id;
    }
}
