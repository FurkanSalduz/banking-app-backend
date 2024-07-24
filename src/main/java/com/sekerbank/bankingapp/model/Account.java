package com.sekerbank.bankingapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String accountNumber;

    @NotNull
    @Column(nullable = false)
    private String accountType;

    @NotNull
    @Column(nullable = false)
    private Double balance;

    @NotNull
    @Column(nullable = false)
    private Long userId; // Kullanıcı ID'si alanı

    // Lombok'un @Data anotasyonu tüm getter ve setter metodlarını sağlar,
    // bu yüzden manuel olarak getter ve setter metodları eklemeye gerek yoktur.

    // Diğer gerekli alanlar ve metodlar
}
