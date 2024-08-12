package com.sekerbank.bankingapp.controller;

import com.sekerbank.bankingapp.Dto.CardDTO;
import com.sekerbank.bankingapp.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping("/byUserId/{userId}")
    public List<CardDTO> getCardsByUserId(@PathVariable Long userId) {
        return cardService.getCardsByUserId(userId);

    }
    @PostMapping("/create")
    public CardDTO createCard(@RequestBody CardDTO cardDTO) {
        return cardService.createCard(cardDTO);
    }
}
