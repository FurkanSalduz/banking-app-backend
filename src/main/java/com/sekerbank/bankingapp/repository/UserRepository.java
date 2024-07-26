package com.sekerbank.bankingapp.repository;

import com.sekerbank.bankingapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Kullanıcı adını kullanarak kullanıcıyı bulur
    User findByUsername(String username);



}
