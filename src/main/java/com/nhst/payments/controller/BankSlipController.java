package com.nhst.payments.controller;


import com.nhst.payments.controller.dto.PostBankSplitDTO;
import com.nhst.payments.service.BankSlipService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/boletos")
@RequiredArgsConstructor
public class BankSlipController {

    private final BankSlipService service;

    @PostMapping
    public ResponseEntity<?> postBankSplit(@RequestBody @Valid PostBankSplitDTO dto) {

        var paymentId = service.create(dto);

        return ResponseEntity.ok(paymentId);
    }
}