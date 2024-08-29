package com.sparta.springexpert.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Getter
@Entity
@NoArgsConstructor
public class User extends Timestamped {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String userName;

    public User(String email, String userName){
        this.email = email;
        this.userName = userName;
    }
}
