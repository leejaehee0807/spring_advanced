package com.sparta.springexpert.dto.user.response;

import lombok.Getter;

@Getter
public class UserSaveResponseDto {
    private final Long id;
    private final String email;
    private final String userName;

    public UserSaveResponseDto(Long id, String email, String userName) {
        this.id = id;
        this.email = email;
        this.userName = userName;
    }
}
