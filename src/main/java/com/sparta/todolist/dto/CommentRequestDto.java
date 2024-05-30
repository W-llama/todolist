package com.sparta.todolist.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentRequestDto {
    private long commentid;          //아이디(고유번호)
    private String comment;          //댓글 내용
    private String userid;           //사용자 아이디
    private long id;                 //todo 아이디
    private LocalDateTime createdAt; //작성일자

}
