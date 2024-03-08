package com.project.hexagonal.adapter.in.web;

import com.project.hexagonal.application.port.in.DepositUseCase;
import com.project.hexagonal.application.port.in.WithdrawUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class BankAccountController {
    private final DepositUseCase depositUseCase;
    private final WithdrawUseCase withdrawUseCase;

    @PostMapping(value = "/{id}/deposit/{amount}")
    void deposit(@PathVariable final Long id,
                 @PathVariable final BigDecimal ammount) {
        depositUseCase.deposit(id, ammount);
    }

    @PostMapping(value = "/{id}/withdraw/{amount}")
    void withdraw(@PathVariable final Long id,
                 @PathVariable final BigDecimal ammount) {
        withdrawUseCase.withdraw(id, ammount);
    }
}
