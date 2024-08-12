// src/main/java/com/sekerbank/bankingapp/service/CardService.java
package com.sekerbank.bankingapp.service;

import com.sekerbank.bankingapp.Dto.CardDTO;
import com.sekerbank.bankingapp.model.Card;
import com.sekerbank.bankingapp.model.User;
import com.sekerbank.bankingapp.repository.CardRepository;
import com.sekerbank.bankingapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private UserRepository userRepository;

    public List<CardDTO> getCardsByUserId(Long userId) {
        List<Card> cards = cardRepository.findByUserId(userId);
        return cards.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public CardDTO createCard(CardDTO cardDTO) {
        User user = userRepository.findById(cardDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Card card = new Card();
        card.setCardNumber(cardDTO.getCardNumber());
        card.setCardType(cardDTO.getCardType());
        card.setCardholderName(user.getUsername()); // Kullanıcı adını kart üzerindeki isim olarak ayarla
        card.setExpirationDate(cardDTO.getExpirationDate());
        card.setUser(user);

        Card savedCard = cardRepository.save(card);
        return convertToDTO(savedCard);
    }

    private CardDTO convertToDTO(Card card) {
        CardDTO cardDTO = new CardDTO();
        cardDTO.setId(card.getId());
        cardDTO.setCardNumber(card.getCardNumber());
        cardDTO.setCardType(card.getCardType());
        cardDTO.setCardholderName(card.getUser().getUsername()); // Kullanıcı adını DTO'ya ekle
        cardDTO.setExpirationDate(card.getExpirationDate());
        cardDTO.setUserId(card.getUser().getId());
        return cardDTO;
    }
}
