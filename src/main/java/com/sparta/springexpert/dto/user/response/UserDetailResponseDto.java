package com.sparta.springexpert.dto.user.response;

import lombok.Getter;

@Getter
public class UserDetailResponseDto {
    private final Long id;
    private final String email;
    private final String userName;

    public UserDetailResponseDto(Long id, String email, String userName) {
        this.id = id;
        this.email = email;
        this.userName = userName;
    }
}
