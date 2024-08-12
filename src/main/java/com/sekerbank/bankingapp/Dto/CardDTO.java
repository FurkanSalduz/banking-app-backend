// src/main/java/com/sekerbank/bankingapp/dto/CardDTO.java
package com.sekerbank.bankingapp.Dto;

import lombok.Data;

@Data
public class CardDTO {

    private Long id;
    private String cardNumber;
    private String cardType;
    private String cardholderName; // Kart üzerindeki isim
    private String expirationDate;
    private Long userId;
}
