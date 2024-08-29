package com.sparta.springexpert.dto.todo.request;

import lombok.Getter;

@Getter
public class TodoSaveRequestDto {
    private String todoTitle;
    private String todoContent;
    private String userName;
}
