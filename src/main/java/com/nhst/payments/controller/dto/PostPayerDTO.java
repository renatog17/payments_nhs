package com.nhst.payments.controller.dto;

public record PostPayerDTO(
        String name,
        String document,
        PostAddressDTO address
) {}