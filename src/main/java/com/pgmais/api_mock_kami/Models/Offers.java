package com.pgmais.api_mock_kami.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Offers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contract;
    private String product;
    private LocalDate dueDate;
    private LocalDate inputLimitDate;

    @ElementCollection
    @CollectionTable(name = "offers_payment_options", joinColumns = @JoinColumn(name = "offers_id"))
    private List<PaymentOption> paymentOptions;

    @Embeddable
    @Data
    @NoArgsConstructor
    public static class PaymentOption {
        private String id;
        private double value;
        private int installmentsNumber;
        private double installmentValue;
        private LocalDate dueDate;
    }
}


    /* lista com as opções de pagamento
    private ArrayList<PaymentOption> paymentOptions;
    @Data
    @NoArgsConstructor
    public static class PaymentOption {
    private String id;
    private double value;
    private int installmentsNumber;
    private double installmentValue;
    private LocalDate dueDate;
    }*/

