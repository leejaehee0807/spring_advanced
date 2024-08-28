package com.sparta.springexpert.dto.comment.response;

import lombok.Getter;

@Getter
public class CommentSimpleResponseDto {
    private final String content;

    public CommentSimpleResponseDto(String content) {
        this.content = content;
    }
}
