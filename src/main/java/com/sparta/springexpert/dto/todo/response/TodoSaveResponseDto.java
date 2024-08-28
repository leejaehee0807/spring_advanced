package com.sparta.springexpert.dto.todo.response;

import lombok.Getter;

@Getter
public class TodoSaveResponseDto {
    private final Long id;
    private final String todoTitle;
    private final String todoContent;

    public TodoSaveResponseDto(Long id, String todoTitle, String todoContent) {
        this.id = id;
        this.todoTitle = todoTitle;
        this.todoContent = todoContent;
    }
}
