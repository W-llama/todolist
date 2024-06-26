package com.sparta.todolist.repository;

import com.sparta.todolist.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findAllByOrderByModifiedAtDesc();
    List<Todo> findAllByContentsContainsOrderByModifiedAtDesc(String keyword); //특정 키워드 list에서 검색
}