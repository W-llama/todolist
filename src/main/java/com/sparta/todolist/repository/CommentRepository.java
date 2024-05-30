package com.sparta.todolist.repository;

import com.sparta.todolist.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByOrderByModifiedAtDesc();
    List<Comment> findAllByIdOrderByModifiedAtDesc(Long id); //시간순으로 정렬 (선택한 id)

}
