package com.sparta.todolist.dto;

import com.sparta.todolist.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto {
    private long id;          //아이디(고유번호)
    private String comment;          //댓글 내용
    private String userid;           //사용자 아이디
    private long todo_id;                 //todo 아이디
    private LocalDateTime createdAt; //작성일자
    private LocalDateTime modifiedAt;

    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.comment = comment.getComment();
        this.userid = comment.getUserid();
        this.todo_id = comment.getTodo().getId();
        this.createdAt = comment.getCreatedAt();
        this.modifiedAt = comment.getModifiedAt();

    }


}
