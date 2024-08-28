package com.sparta.springexpert.dto.todo.request;

import lombok.Getter;

@Getter
public class TodoUpdateRequestDto {
    private String todoTitle;
    private String todoContent;
}
