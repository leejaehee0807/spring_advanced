package com.sparta.springexpert.repository;

import com.sparta.springexpert.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
