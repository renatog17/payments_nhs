package com.nhst.payments.controller.dto;


import java.math.BigDecimal;
import java.time.LocalDate;

public record PostTitleDTO(
        String documentNumber,
        BigDecimal amount,
        LocalDate dueDate,
        LocalDate issueDate
) {}