package com.sparta.todolist.dto;

import com.sparta.todolist.entity.Todo;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoResponseDto {
    private Long id;
    private String title;
    private String contents;
    private String userName;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;


    public TodoResponseDto(Todo todo) {
        this.id = todo.getId();
        this.title = todo.getTitle();
        this.contents = todo.getContents();
        this.userName = todo.getUserName();
        this.password = todo.getPassword();
        this.createdAt = todo.getCreatedAt();
        this.modifiedAt = todo.getModifiedAt();
    }
}
