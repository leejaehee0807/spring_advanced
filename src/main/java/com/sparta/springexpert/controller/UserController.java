package com.sparta.springexpert.controller;

import com.sparta.springexpert.dto.user.request.UserSaveRequestDto;
import com.sparta.springexpert.dto.user.response.UserDetailResponseDto;
import com.sparta.springexpert.dto.user.response.UserSaveResponseDto;
import com.sparta.springexpert.dto.user.response.UserSimpleResponseDto;
import com.sparta.springexpert.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public UserSaveResponseDto saveUser(@RequestBody UserSaveRequestDto userSaveRequestDto){
        return userService.saveUser(userSaveRequestDto);
    }

    @GetMapping("/users")
    public List<UserSimpleResponseDto> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/users/{userId}")
    public UserDetailResponseDto getUser(@PathVariable Long userId){
        return userService.getUser(userId);
    }
    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
    }

}
