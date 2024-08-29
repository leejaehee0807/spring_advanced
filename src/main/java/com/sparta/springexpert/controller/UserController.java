package com.sparta.springexpert.controller;

import com.sparta.springexpert.dto.user.request.UserSaveRequestDto;
import com.sparta.springexpert.dto.user.response.UserDetailResponseDto;
import com.sparta.springexpert.dto.user.response.UserSaveResponseDto;
import com.sparta.springexpert.dto.user.response.UserSimpleResponseDto;
import com.sparta.springexpert.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<UserSaveResponseDto> saveUser(@RequestBody UserSaveRequestDto userSaveRequestDto){
        return ResponseEntity.ok(userService.saveUser(userSaveRequestDto));
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserSimpleResponseDto>> getUsers(){
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<UserDetailResponseDto> getUser(@PathVariable Long userId){
        return ResponseEntity.ok(userService.getUser(userId));
    }
    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
    }

}
