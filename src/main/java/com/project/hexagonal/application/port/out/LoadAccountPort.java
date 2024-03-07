package com.project.hexagonal.application.port.out;

import com.project.hexagonal.domain.BankAccount;

public interface LoadAccountPort {
    BankAccount load(Long id);
}
