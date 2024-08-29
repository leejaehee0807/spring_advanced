package com.sparta.springexpert.service;

import com.sparta.springexpert.dto.todo.request.TodoSaveRequestDto;
import com.sparta.springexpert.dto.todo.request.TodoUpdateRequestDto;
import com.sparta.springexpert.dto.todo.response.TodoDetailResponseDto;
import com.sparta.springexpert.dto.todo.response.TodoSaveResponseDto;
import com.sparta.springexpert.dto.todo.response.TodoUpdateResponseDto;
import com.sparta.springexpert.entity.Todo;
import com.sparta.springexpert.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TodoService {

    private final TodoRepository todoRepository;

    @Transactional
    public TodoSaveResponseDto saveTodo(TodoSaveRequestDto todoSaveRequestDto) {
        Todo todo = new Todo(
                todoSaveRequestDto.getTodoTitle(),
                todoSaveRequestDto.getTodoContent(),
                todoSaveRequestDto.getUserName());
        Todo savedTodo = todoRepository.save(todo);

        return new TodoSaveResponseDto(
                savedTodo.getId(),
                savedTodo.getTodoTitle(),
                savedTodo.getTodoContent());
    }

    public Page<TodoDetailResponseDto> getTodo(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);

        Page<Todo> todos = todoRepository.findAllByOrderByModifiedAtDesc(pageable);

        return todos.map(todo -> new TodoDetailResponseDto(
                todo.getId(),
                todo.getTodoTitle(),
                todo.getTodoContent(),
                todo.getComments().size(),
                todo.getUserName()
        ));

//        Todo todo = todoRepository.findById(todoId).orElseThrow(()->new NullPointerException("조회한 id가 없습니다."));
//        return new TodoDetailResponseDto(
//                todo.getId(),
//                todo.getTodoTitle(),
//                todo.getTodoContent());
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
