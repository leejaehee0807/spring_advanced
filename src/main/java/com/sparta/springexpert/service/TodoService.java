package com.sparta.springexpert.service;

import com.sparta.springexpert.dto.*;
import com.sparta.springexpert.entity.Todo;
import com.sparta.springexpert.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TodoService {

    private final TodoRepository todoRepository;

    @Transactional
    public TodoSaveResponseDto saveTodo(TodoSaveRequestDto todoSaveRequestDto) {
        Todo todo = new Todo(todoSaveRequestDto.getTodoTitle(), todoSaveRequestDto.getTodoContent());
        Todo savedTodo = todoRepository.save(todo);

        return new TodoSaveResponseDto(
                savedTodo.getId(),
                savedTodo.getTodoTitle(),
                savedTodo.getTodoContent());
    }

    public TodoDetailResponseDto getTodo(Long todoId) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(()->new NullPointerException("조회한 id가 없습니다."));
        return new TodoDetailResponseDto(
                todo.getId(),
                todo.getTodoTitle(),
                todo.getTodoContent());
    }

    @Transactional
    public TodoUpdateResponseDto updateTodo(Long todoId, TodoUpdateRequestDto todoUpdateRequestDto) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(()->new NullPointerException("업데이트할 id가 없습니다."));
        todo.update(todoUpdateRequestDto.getTodoTitle(), todoUpdateRequestDto.getTodoContent());

        return new TodoUpdateResponseDto(
                todo.getId(),
                todo.getTodoTitle(),
                todo.getTodoContent());

    }
}
