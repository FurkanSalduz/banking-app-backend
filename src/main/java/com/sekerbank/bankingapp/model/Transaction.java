package com.sekerbank.bankingapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "transactions") // Tablo ismini burada belirtiyoruz
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Boş değer olamaz")
    private Double wallet;

    private String description;

    @NotNull(message = "Boş değer olamaz")
    private String account_type; //

    @NotNull(message = "Boş değer olamaz")
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "account_id")  //hesap tablosu ile ilişkilendirildi
    private Account account;

    @ManyToOne
    @JoinColumn(name = "to_account_id")
    private Account to_account;
    // Getters and setters

}
