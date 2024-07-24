package com.sekerbank.bankingapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Boş değer olamaz")
    private Double amount;

    private String description;

    @NotNull(message = "Boş değer olamaz")
    private String type; // Örneğin, "DEPOSIT", "WITHDRAWAL" gibi

    @NotNull(message = "Boş değer olamaz")
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    // Getters and setters
}
