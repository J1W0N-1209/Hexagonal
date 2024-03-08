package com.project.hexagonal.application.port.in;

import java.math.BigDecimal;

public interface WithdrawUseCase {
    boolean withdraw(Long id, BigDecimal amount);
}
