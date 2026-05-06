package com.nhst.payments.controller;


import com.nhst.payments.service.BankSlipService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boletos")
@RequiredArgsConstructor
public class BankSlipController {

    private final BankSlipService service;
}