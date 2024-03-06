package com.nhnacademy.edu.springboot.accountapi.repository;

import com.nhnacademy.edu.springboot.accountapi.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findAllByOrderById();
}
