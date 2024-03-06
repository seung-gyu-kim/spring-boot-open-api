package com.nhnacademy.edu.springboot.accountapi.repository;

import com.nhnacademy.edu.springboot.accountapi.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
