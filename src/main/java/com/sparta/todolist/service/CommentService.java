package com.sparta.todolist.service;

import com.sparta.todolist.dto.CommentRequestDto;
import com.sparta.todolist.dto.CommentResponseDto;
import com.sparta.todolist.entity.Comment;
import com.sparta.todolist.entity.Todo;
import com.sparta.todolist.repository.CommentRepository;
import com.sparta.todolist.repository.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final TodoService todoService;
    private final TodoRepository todoRepository;

    public CommentService(CommentRepository commentRepository, TodoService todoService, TodoRepository todoRepository) {
        this.commentRepository = commentRepository;
        this.todoService = todoService;
        this.todoRepository = todoRepository;
    }

    public CommentResponseDto createComment(Long id,CommentRequestDto commentRequestDto) {
        // RequestDto - Entity
        Todo todo = todoService.findTodo(id);

        Comment comment = new Comment(commentRequestDto, todo);

        //DB에 저장
        commentRepository.save(comment);

        // Entity - ResponseDto
        CommentResponseDto commentResponseDto = new CommentResponseDto(comment);

        return commentResponseDto;
    }

    public List<CommentResponseDto> getComment() {
        // DB 조회
        return commentRepository.findAllByOrderByModifiedAtDesc().stream().map(CommentResponseDto::new).toList();
    }
    //수정
    @Transactional
    public Long updateComment(Long commentId, CommentRequestDto commentRequestDto) {
        Comment comment = findComment(commentId);

        comment.update(commentRequestDto);

        return commentId;

    }

    public Long deleteComment(Long commentId) {
        Comment comment = findComment(commentId);

        commentRepository.delete(comment);

        return commentId;
    }

    private Comment findComment(Long commentId) {
        return commentRepository.findById(commentId).orElseThrow(() ->
                new IllegalArgumentException("선택한 댓글은 존재하지 않습니다.")
        );
    }
}
