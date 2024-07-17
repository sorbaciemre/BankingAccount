package com.zad.bankaccount.repository;

import com.zad.bankaccount.entity.Account;
import com.zad.bankaccount.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @Created 16.07.2024
 * @Author emresorbaci
 **/
public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByUser(User user);

    Optional<Account> findByUserAndCurrency(User user, String currency);
}
