package com.nhst.payments.domain;

import com.nhst.payments.domain.enums.BankSlipStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "bank_slips")
public class BankSlip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nossoNumero;

    private String documentNumber;

    private BigDecimal amount;

    @ManyToOne
    private Beneficiary beneficiary;

    @ManyToOne
    private Payer payer;

    private LocalDate dueDate;

    private LocalDate issueDate;

    @Enumerated(EnumType.STRING)
    private BankSlipStatus status;

    private String barcode;

    private String digitableLine;

    private LocalDateTime paidAt;

    private LocalDateTime createdAt;
}