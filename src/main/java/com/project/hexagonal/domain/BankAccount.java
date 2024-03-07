package com.project.hexagonal.domain;

import lombok.Builder;

import java.math.BigDecimal;

// POJO 특정 라이브러리에 종속적이지 않아서 테스트에 쉬워진다. => 클린 아키텍처
public class BankAccount {
    private Long id;
    private BigDecimal balance;

    @Builder
    public BankAccount(Long id, BigDecimal balance) {
        this.id = id;
        this.balance = balance;
    }

    public boolean withdraw(BigDecimal amount) {
        if(balance.compareTo(amount) < 0) {
            return false;
        }

        balance = balance.subtract(amount);
        return true;
    }

    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
    }

    public BigDecimal getBalance() {
        return balance;
    }

}
