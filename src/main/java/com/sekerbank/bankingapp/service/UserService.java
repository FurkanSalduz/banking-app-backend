package com.sekerbank.bankingapp.service;

import com.sekerbank.bankingapp.model.User;
import com.sekerbank.bankingapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {

        return userRepository.findById(id);
    }

    public User saveUser(User user) {

        return userRepository.save(user);
    }

    public void deleteUser(Long id)
    {
        userRepository.deleteById(id);
    }

    public ResponseEntity<User> authenticateUser(String username, String password) {
        // Kullanıcıyı username ile veritabanında bul
        User user = userRepository.findByUsername(username);

        // Kullanıcı bulunamadıysa uygun hata mesajı döndür
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); // Kullanıcı bulunamadı, 401 Unauthorized döndür
        }

        try {
            // Şifreyi kontrol et
            if (user.getPassword().equals(password)) {
                return ResponseEntity.ok(user); // Şifre doğruysa User nesnesini döndür
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); // Şifre yanlışsa 401 Unauthorized döndür
            }
        } catch (Exception e) {
            // Hata durumunda uygun mesaj döndür
            throw new RuntimeException("Error during authentication", e); // İstisna fırlat
        }
    }
}

