package com.nhst.payments.controller.dto;

import java.math.BigDecimal;

public record PostChargesDTO(
        BigDecimal finePercent,
        BigDecimal interestPerDay
) {}