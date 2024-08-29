package com.sparta.springexpert.service;

import com.sparta.springexpert.dto.user.request.UserSaveRequestDto;
import com.sparta.springexpert.dto.user.response.UserDetailResponseDto;
import com.sparta.springexpert.dto.user.response.UserSaveResponseDto;
import com.sparta.springexpert.dto.user.response.UserSimpleResponseDto;
import com.sparta.springexpert.entity.User;
import com.sparta.springexpert.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserSaveResponseDto saveUser(UserSaveRequestDto userSaveRequestDto) {
        User newUser = new User(userSaveRequestDto.getEmail(),userSaveRequestDto.getUserName());
        User savedUser = userRepository.save(newUser);

        return new UserSaveResponseDto(savedUser.getId(), savedUser.getEmail(), savedUser.getUserName());
    }

    public List<UserSimpleResponseDto> getUsers() {
        List<User> newUsers = userRepository.findAll();
        List<UserSimpleResponseDto> userSimpleResponseDto = new ArrayList<>();
        for (User newUser : newUsers) {
            userSimpleResponseDto.add(new UserSimpleResponseDto(
                    newUser.getUserName()));
        }
        return userSimpleResponseDto;
    }

    public UserDetailResponseDto getUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(()->new NullPointerException("유저가 없습니다."));
        return new UserDetailResponseDto(
                user.getId(),
                user.getEmail(),
                user.getUserName());
    }

    @Transactional
    public void deleteUser(Long userId) {
        if (userRepository.existsById(userId)) {
            throw new NullPointerException("유저가 없습니다.");
        }
        userRepository.deleteById(userId);
    }
}
