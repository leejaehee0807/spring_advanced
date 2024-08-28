package com.sparta.springexpert.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Comment extends Timestamped {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todo_id")
    private Todo todo;

    public Comment(String content) {
        this.content = content;
    }
    public void update(String content){
        this.content= content;
    }
}
