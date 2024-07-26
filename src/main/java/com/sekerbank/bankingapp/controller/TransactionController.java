package com.sekerbank.bankingapp.controller;

import com.sekerbank.bankingapp.Dto.TransactionRequest;
import com.sekerbank.bankingapp.model.Transaction;
import com.sekerbank.bankingapp.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {


    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/GetAllTransactions")
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/GetById{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable Long id) {
        Optional<Transaction> transaction = transactionService.getTransactionById(id);
        return transaction.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/CreateTransaction")
    public ResponseEntity<String> createTransaction(@Valid @RequestBody TransactionRequest transactionRequest) {
        return transactionService.saveTransaction(transactionRequest);
    }

    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
        return ResponseEntity.noContent().build();
    }
}