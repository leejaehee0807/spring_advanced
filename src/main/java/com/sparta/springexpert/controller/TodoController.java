package com.sparta.springexpert.controller;

import com.sparta.springexpert.dto.todo.request.TodoSaveRequestDto;
import com.sparta.springexpert.dto.todo.request.TodoUpdateRequestDto;
import com.sparta.springexpert.dto.todo.response.TodoDetailResponseDto;
import com.sparta.springexpert.dto.todo.response.TodoSaveResponseDto;
import com.sparta.springexpert.dto.todo.response.TodoUpdateResponseDto;
import com.sparta.springexpert.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @PostMapping("/todo")
    public TodoSaveResponseDto saveTodo(@RequestBody TodoSaveRequestDto todoSaveRequestDto){
        return todoService.saveTodo(todoSaveRequestDto);
    }

    @GetMapping("/todo/{todoId}")
    public TodoDetailResponseDto getTodo(@PathVariable Long todoId){
        return todoService.getTodo(todoId);
    }

    @PutMapping("/todo/{todoId}")
    public TodoUpdateResponseDto updateTodo(@PathVariable Long todoId, @RequestBody TodoUpdateRequestDto todoUpdateRequestDto){
        return todoService.updateTodo(todoId,todoUpdateRequestDto);
    }
    
}
