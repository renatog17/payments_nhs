package com.nhst.payments.controller.dto;

public record PostAddressDTO(
        String street,
        String number,
        String city,
        String state,
        String zipCode
) {}