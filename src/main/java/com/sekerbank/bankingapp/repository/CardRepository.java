package com.sekerbank.bankingapp.repository;

import com.sekerbank.bankingapp.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> findByUserId(Long userId); // Kullanıcının kartlarını bulmak için
}
