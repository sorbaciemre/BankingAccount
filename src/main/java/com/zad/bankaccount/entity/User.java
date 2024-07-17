package com.zad.bankaccount.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

/**
 * @Created 16.07.2024
 * @Author emresorbaci
 **/
@Data
@Entity(name = "BANK_USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Account> accounts;

}
