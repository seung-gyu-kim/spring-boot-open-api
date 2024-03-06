package com.nhnacademy.edu.springboot.openapi.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.NotNull;

@ConfigurationProperties(prefix = "com.nhnacademy.account")
@Data
public class AccountAdaptorProperties {

    @NotNull
    private String address;
}
