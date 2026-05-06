package com.nhst.payments.service;

import com.nhst.payments.controller.dto.PostBankSplitDTO;
import com.nhst.payments.controller.dto.ReadBlankSplitDTO;
import com.nhst.payments.domain.*;
import com.nhst.payments.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BankSlipService {

    private final PaymentRepository paymentRepository;

    public ReadBlankSplitDTO create(PostBankSplitDTO dto) {

        var beneficiary = new Beneficiary();
        beneficiary.setName(dto.beneficiary().name());
        beneficiary.setDocument(dto.beneficiary().document());
        beneficiary.setAgency(dto.beneficiary().agency());
        beneficiary.setAccount(dto.beneficiary().account());

        var address = new Address();
        address.setStreet(dto.payer().address().street());
        address.setNumber(dto.payer().address().number());
        address.setCity(dto.payer().address().city());
        address.setState(dto.payer().address().state());
        address.setZipCode(dto.payer().address().zipCode());

        var payer = new Payer();
        payer.setName(dto.payer().name());
        payer.setDocument(dto.payer().document());
        payer.setAddress(address);

        var title = new Title();
        title.setDocumentNumber(dto.title().documentNumber());
        title.setAmount(dto.title().amount());
        title.setDueDate(dto.title().dueDate());
        title.setIssueDate(dto.title().issueDate());

        var charges = new Charges();
        charges.setFinePercent(dto.charges().finePercent());
        charges.setInterestPerDay(dto.charges().interestPerDay());

        var payment = new Payment();
        payment.setBeneficiary(beneficiary);
        payment.setPayer(payer);
        payment.setTitle(title);
        payment.setCharges(charges);

        var saved = paymentRepository.save(payment);
        // Simulação de retorno bancário
        String nossoNumero = UUID.randomUUID().toString();
        String barcode = "23793" + System.currentTimeMillis();
        String digitableLine = "23790.12345 67890.123456 78901.234567 1 12345678900000";
        String pdfUrl = "https://fake-bank.com/boletos/" + nossoNumero + ".pdf";

        return new ReadBlankSplitDTO(
                "REGISTERED",
                nossoNumero,
                saved.getTitle().getDocumentNumber(),
                barcode,
                digitableLine,
                saved.getTitle().getAmount(),
                saved.getTitle().getDueDate(),
                pdfUrl,
                null,
                "Boleto registrado com sucesso"
        );
    }
}