package com.sparta.todolist.controller;

import com.sparta.todolist.dto.TodoRequestDto;
import com.sparta.todolist.dto.TodoResponseDto;
import com.sparta.todolist.entity.Todo;
import com.sparta.todolist.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TodoController {

    public final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/todo")
    public TodoResponseDto createTodo(@RequestBody TodoRequestDto requestDto){
        return todoService.createTodo(requestDto);
    }

    @GetMapping("/todo")
    public List<TodoResponseDto> getTodo(){
        return todoService.getTodo();
    }

    @GetMapping("/todo/contents")
    public List<TodoResponseDto> getTodoByKeyword(String keyword){
        return todoService.getTodoByKeyword(keyword);
    }
    @PutMapping("/todo/{id}")
    public Long updateTodo(@PathVariable Long id, @RequestBody TodoRequestDto requestDto){
        return todoService.updateTodo(id, requestDto);
    }

    @DeleteMapping("/todo/{id}")
    public Long deleteTodo(@PathVariable Long id){
        return todoService.deleteTodo(id);
    }

}
