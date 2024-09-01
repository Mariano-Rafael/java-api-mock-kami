package com.pgmais.api_mock_kami.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

// campos response do endpoint de agreements
@Entity
@Data
@NoArgsConstructor
public class Agreements {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int clientId;
    private LocalDate dueDate;
    private String digitableLine;
}
