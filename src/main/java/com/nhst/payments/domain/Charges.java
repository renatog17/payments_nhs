package com.nhst.payments.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "charges")
public class Charges {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(precision = 5, scale = 2)
    private BigDecimal finePercent;

    @Column(precision = 5, scale = 4)
    private BigDecimal interestPerDay;

}