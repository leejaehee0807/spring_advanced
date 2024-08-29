package com.sparta.springexpert.dto.comment.response;

import lombok.Getter;

@Getter
public class CommentUpdateResponseDto {
    private final Long id;
    private final String content;
    private final String userName;


    public CommentUpdateResponseDto(Long id, String content, String userName) {
        this.id = id;
        this.content = content;
        this.userName = userName;
    }
}
