package com.nhst.payments.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "beneficiary_id", nullable = false)
    private Beneficiary beneficiary;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payer_id", nullable = false)
    private Payer payer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "title_id", nullable = false)
    private Title title;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "charges_id", nullable = false)
    private Charges charges;

    public BigDecimal calculateTotal(LocalDate paymentDate) {
        BigDecimal base = title.getAmount();

        if (paymentDate.isAfter(title.getDueDate())) {
            long daysLate = ChronoUnit.DAYS.between(title.getDueDate(), paymentDate);

            BigDecimal fine = base.multiply(
                    charges.getFinePercent().divide(BigDecimal.valueOf(100))
            );

            BigDecimal interest = base
                    .multiply(charges.getInterestPerDay().divide(BigDecimal.valueOf(100)))
                    .multiply(BigDecimal.valueOf(daysLate));

            return base.add(fine).add(interest);
        }

        return base;
    }

}