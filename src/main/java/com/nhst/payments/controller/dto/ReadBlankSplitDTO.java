package com.nhst.payments.controller.dto;


import java.math.BigDecimal;
import java.time.LocalDate;

public record ReadBlankSplitDTO(
        String status,          // REGISTERED | REJECTED
        String nossoNumero,
        String documentNumber,
        String barcode,
        String digitableLine,
        BigDecimal amount,
        LocalDate dueDate,
        String pdfUrl,
        String errorCode,
        String message
) {}