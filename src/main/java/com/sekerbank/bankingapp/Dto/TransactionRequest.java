package com.sekerbank.bankingapp.Dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class TransactionRequest {

    @NotNull(message = "Wallet amount cannot be null")
    private Double wallet;

    private String description;

    @NotNull(message = "Account type cannot be null")
    private String account_type; // account type

    @NotNull(message = "Timestamp cannot be null")
    private LocalDateTime timestamp;

    @NotNull(message = "Account ID cannot be null")
    private Long accountId;

    private Long toAccountId; // Optional, as not all transactions require a destination account

}
