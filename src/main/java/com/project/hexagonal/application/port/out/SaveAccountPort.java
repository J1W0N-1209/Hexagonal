package com.project.hexagonal.application.port.out;

import com.project.hexagonal.domain.BankAccount;

public interface SaveAccountPort {
    void save(BankAccount bankAccount);
}
