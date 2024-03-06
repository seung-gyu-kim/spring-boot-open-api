package com.nhnacademy.edu.springboot.openapi.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class AccountRequest {
    @NotNull
    private Integer balance;
    @NotNull
    private Long customerId;
}
