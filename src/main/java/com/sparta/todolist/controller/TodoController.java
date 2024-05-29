package com.sparta.todolist.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    @PostMapping("/todo")
    public ResponseEntity postTodo() {
        return ResponseEntity.ok().build();
    }
}
