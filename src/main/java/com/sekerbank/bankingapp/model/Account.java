package com.sekerbank.bankingapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "accounts") // Tablo ismini burada belirtiyoruz
@Data

public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false ,unique = true)
    private String accountNumber;

    @NotNull
    @Column(nullable = false)
    private String accountType;  // Örneğin vadeli vadesiz

    @NotNull
    @Column(nullable = false)
    private Double balance;

    // Kullanıcı ID'si alanı
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;






    // Lombok'un @Data anotasyonu tüm getter ve setter metodlarını sağlar,
    // bu yüzden manuel olarak getter ve setter metodları eklemeye gerek yoktur.

    // Diğer gerekli alanlar ve metodlar
}
