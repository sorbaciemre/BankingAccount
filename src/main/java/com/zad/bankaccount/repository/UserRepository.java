package com.zad.bankaccount.repository;

import com.zad.bankaccount.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @Created 16.07.2024
 * @Author emresorbaci
 **/
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
