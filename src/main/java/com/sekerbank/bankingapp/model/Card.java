package com.sekerbank.bankingapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "cards") // Tablo ismini burada belirtiyoruz
@Data
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false, unique = true)
    private String cardNumber; // Kart Numarası

    @NotNull
    @Column(nullable = false)
    private String cardType; // Kart Türü - Örneğin: Kredi Kartı, Bankamatik Kartı

    @NotNull
    @Column(nullable = false)
    private String cardholderName; // Kart Üzerindeki İsim

    @NotNull
    @Column(nullable = false)
    private String expirationDate; // Son Kullanma Tarihi (MM/YY formatında)

    @ManyToOne
    @JoinColumn(name = "user_id") // Bu kartın bağlı olduğu kullanıcı ID'si
    private User user;
}
