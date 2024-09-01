package com.pgmais.api_mock_kami.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

// campos response do endpoint DEBTS
@Entity
@Data
@NoArgsConstructor
public class Debts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int clientId;
    private String contract;
    private double paymentValue;
    private double originalValue;
    private boolean allowRenegociation;
    private String product;
    private String status;
    private LocalDate dueDate;
    private int overDueDays;
    private String clientCode;
    private int minimumInstallmentNumber;
    private int maximumInstallmentNumber;
    private LocalDate minimumInstallmentDueDate;
    private LocalDate maximumInstallmentDueDate;
}
