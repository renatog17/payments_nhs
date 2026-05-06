package com.nhst.payments.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {

    private String street;
    private String number;
    private String city;
    private String state;
    private String zipCode;
}