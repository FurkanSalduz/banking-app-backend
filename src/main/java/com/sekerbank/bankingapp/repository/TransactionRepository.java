package com.sekerbank.bankingapp.repository;

import com.sekerbank.bankingapp.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    // Özelleştirilmiş sorgular ekleyebilirsiniz.
}
