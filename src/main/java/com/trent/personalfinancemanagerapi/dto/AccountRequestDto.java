package com.trent.personalfinancemanagerapi.dto;

import com.trent.personalfinancemanagerapi.enums.AccountType;

import java.math.BigDecimal;

public class AccountRequestDto {
    private String name;
    private AccountType type;
    private BigDecimal balance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

}
