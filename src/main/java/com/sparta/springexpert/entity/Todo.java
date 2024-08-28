package com.sparta.springexpert.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Todo extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String todoTitle;
    private String todoContent;

    public Todo (String todoTitle, String todoContent){
        this.todoTitle = todoTitle;
        this.todoContent = todoContent;
    }
    public void update(String todoTitle, String todoContent){
        this.todoTitle=todoTitle;
        this.todoContent=todoContent;
    }
}


