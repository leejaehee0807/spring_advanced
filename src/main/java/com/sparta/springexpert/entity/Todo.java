package com.sparta.springexpert.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class Todo extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String todoTitle;
    private String todoContent;

    @OneToMany(mappedBy = "Comment")
    private List<Comment> comments = new ArrayList<>();


    public Todo (String todoTitle, String todoContent){
        this.todoTitle = todoTitle;
        this.todoContent = todoContent;
    }
    public void update(String todoTitle, String todoContent){
        this.todoTitle=todoTitle;
        this.todoContent=todoContent;
    }
}


