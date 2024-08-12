package com.sekerbank.bankingapp.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "users") // Tablo ismini burada belirtiyoruz
@Data
public class User {

    @Id  //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;


}





