package com.nhst.payments.controller.dto;

public record PostBankSplitDTO(
        PostBeneficiaryDTO beneficiary,
        PostPayerDTO payer,
        PostTitleDTO title,
        PostChargesDTO charges
) {}