package com.zad.bankaccount.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Created 16.07.2024
 * @Author emresorbaci
 **/
@Data
@Entity(name = "BANK_ACCOUNT")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String currency;
    private BigDecimal balance;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
