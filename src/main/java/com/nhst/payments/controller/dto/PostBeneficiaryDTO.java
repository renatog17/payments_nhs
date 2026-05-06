package com.nhst.payments.controller.dto;

public record PostBeneficiaryDTO(
        String name,
        String document,
        String agency,
        String account
){
}
