package com.sekerbank.bankingapp.service;

import com.sekerbank.bankingapp.model.Account;
import com.sekerbank.bankingapp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }



    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }
    public List<Account> getAccountsByUserId(Long userId) {
        return accountRepository.findByUserId(userId);
    }

}





