package com.sparta.springexpert.dto.comment.response;

import lombok.Getter;

@Getter
public class CommentSimpleResponseDto {
    private final String content;
    private final String userName;

    public CommentSimpleResponseDto(String content, String userName) {
        this.content = content;
        this.userName = userName;
    }
}
