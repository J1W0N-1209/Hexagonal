package com.project.hexagonal.application.service;

import com.project.hexagonal.application.port.in.DepositUseCase;
import com.project.hexagonal.application.port.in.WithdrawUseCase;
import com.project.hexagonal.application.port.out.LoadAccountPort;
import com.project.hexagonal.application.port.out.SaveAccountPort;
import com.project.hexagonal.domain.BankAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class BankAccountService implements DepositUseCase, WithdrawUseCase {
    private final LoadAccountPort loadAccountPort;
    private final SaveAccountPort saveAccountPort;

    @Override
    public void deposit(Long id, BigDecimal amount) {
        BankAccount account = loadAccountPort.load(id);

        account.deposit(amount);

        saveAccountPort.save(account);
    }

    @Override
    public boolean withdraw(Long id, BigDecimal amount) {
        BankAccount account = loadAccountPort.load(id);

        boolean hasWithdrawn = account.withdraw(amount);

        if(hasWithdrawn) {
            saveAccountPort.save(account);
        }

        return hasWithdrawn;
    }
}
