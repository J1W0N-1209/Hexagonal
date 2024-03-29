package com.project.hexagonal.adapter.out.persistence;

import com.project.hexagonal.domain.BankAccount;
import org.springframework.stereotype.Component;

@Component
public class BankAccountMapper {
    public BankAccount toDomain(BankAccountEntity entity) {
        return BankAccount.builder()
                .id(entity.getId())
                .balance(entity.getBalance())
                .build();
    }

    public BankAccountEntity toEntity(BankAccount domain) {
        return BankAccountEntity.builder()
                .balance(domain.getBalance())
                .build();
    }
}
