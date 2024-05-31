package com.sparta.todolist.dto;

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
