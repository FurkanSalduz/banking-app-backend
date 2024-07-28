package com.sekerbank.bankingapp.service;

import com.sekerbank.bankingapp.Dto.TransactionMapper;
import com.sekerbank.bankingapp.Dto.TransactionRequest;
import com.sekerbank.bankingapp.model.Account;
import com.sekerbank.bankingapp.model.Transaction;
import com.sekerbank.bankingapp.repository.AccountRepository;
import com.sekerbank.bankingapp.repository.TransactionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public TransactionService(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Optional<Transaction> getTransactionById(Long id) {
        return transactionRepository.findById(id);
    }

    public ResponseEntity<String> saveTransaction(TransactionRequest transactionRequest) {
        // DTO'yu Entity'ye dönüştür
        Transaction transaction = TransactionMapper.INSTANCE.toEntity(transactionRequest);

        // Hesapları alın
        Account account = accountRepository.findById(transactionRequest.getAccountId())
                .orElseThrow(() -> new RuntimeException("Account not found"));

        Account toAccount = accountRepository.findByAccountNumber(transactionRequest.getToAccountNumber())
                .orElseThrow(() -> new RuntimeException("Target account not found"));

        // Yetersiz bakiye kontrolü
        if (account.getBalance() < transactionRequest.getWallet()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Insufficient balance");
        }

        // Hesap bakiyelerini güncelle
        account.setBalance(account.getBalance() - transactionRequest.getWallet());
        toAccount.setBalance(toAccount.getBalance() + transactionRequest.getWallet());

        // İşlemi kaydet
        transaction.setAccount(account);
        transaction.setTo_account(toAccount);
        transactionRepository.save(transaction);

        // Hesapları güncelle
        accountRepository.save(account);
        accountRepository.save(toAccount);

        return ResponseEntity.ok("Transaction successfully completed");
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}
