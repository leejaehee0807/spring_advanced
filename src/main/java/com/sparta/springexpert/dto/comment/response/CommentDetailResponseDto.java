package com.sparta.springexpert.dto.comment.response;

import lombok.Getter;

@Getter
public class CommentDetailResponseDto {
    private final Long id;
    private final String content;

    public CommentDetailResponseDto(Long id, String content) {
        this.id = id;
        this.content = content;
    }
}
