package com.nhst.payments.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "titles")
public class Title {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String documentNumber;

    @Column(precision = 15, scale = 2)
    private BigDecimal amount;

    private LocalDate dueDate;
    private LocalDate issueDate;
}