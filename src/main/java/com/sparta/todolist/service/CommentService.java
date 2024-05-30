package com.sparta.todolist.service;

import com.sparta.todolist.dto.CommentRequestDto;
import com.sparta.todolist.dto.CommentResponseDto;
import com.sparta.todolist.entity.Comment;
import com.sparta.todolist.repository.CommentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public CommentResponseDto createComment(CommentRequestDto commentRequestDto) {
        // RequestDto - Entity
        Comment comment = new Comment(commentRequestDto);

        //DB에 저장
        Comment saveComment = commentRepository.save(comment);

        // Entity - ResponseDto
        CommentResponseDto commentResponseDto = new CommentResponseDto(saveComment);

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
