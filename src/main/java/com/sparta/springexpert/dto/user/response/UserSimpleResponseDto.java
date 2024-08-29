package com.sparta.springexpert.dto.user.response;

import lombok.Getter;

@Getter
public class UserSimpleResponseDto {
    private final String UserName;

    public UserSimpleResponseDto(String email) {
        this.UserName = email;
    }
}
