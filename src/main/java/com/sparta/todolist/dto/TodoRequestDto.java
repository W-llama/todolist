package com.sparta.todolist.dto;

import com.sparta.todolist.entity.Todo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoRequestDto {
    private String title;
    private String contents;
    private String userName;
    private String password;
}
