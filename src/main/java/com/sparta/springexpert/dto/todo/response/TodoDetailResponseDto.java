package com.sparta.springexpert.dto.todo.response;

import lombok.Getter;

@Getter
public class TodoDetailResponseDto {
    private final Long id;
    private final String todoTitle;
    private final String todoContent;
    private final int commnetCount;
    private final String userName;

    public TodoDetailResponseDto(Long id, String todoTitle, String todoContent, int commnetCount, String userName) {
        this.id = id;
        this.todoTitle = todoTitle;
        this.todoContent = todoContent;
        this.commnetCount = commnetCount;
        this.userName = userName;
    }
}
