package com.sparta.todolist.controller;

import com.sparta.todolist.dto.CommentRequestDto;
import com.sparta.todolist.dto.CommentResponseDto;
import com.sparta.todolist.dto.TodoRequestDto;
import com.sparta.todolist.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    //선택댓글 추가
    @PostMapping("/{id}")
    public CommentResponseDto createComment(@PathVariable Long id, @RequestBody CommentRequestDto commentRequestDto) {
        return commentService.createComment(commentRequestDto);
    }

    @PutMapping("/{id}")
    public Long updateComment(@PathVariable Long id, @RequestBody CommentRequestDto commentRequestDto){
        return commentService.updateComment(id, commentRequestDto);
    }

    //선택 댓글 조회
    @GetMapping("/{id}")
    public List<CommentResponseDto> getComment(@PathVariable Long id) {
        return commentService.getComment();
    }

    //선택 댓글 삭제
    @DeleteMapping("/{Id}")
    public Long deleteComment(@PathVariable Long commentId) {
        return commentService.deleteComment(commentId);
    }


}
