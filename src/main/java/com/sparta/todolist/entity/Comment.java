package com.sparta.todolist.entity;


import com.sparta.todolist.dto.CommentRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "comment")
@NoArgsConstructor
public class Comment extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "comment_txt", nullable = false)
    private String comment;
    @Column(name = "userid", nullable = false)
    private String userid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="todo_id", nullable = false)
    private Todo todo;



    public Comment(CommentRequestDto commentRequestDto) {
        this.comment = commentRequestDto.getComment();
        this.userid = commentRequestDto.getUserid();
        this.todo = todo;
    }
    public void update(CommentRequestDto commentRequestDto) {
        this.comment = commentRequestDto.getComment();
        this.userid = commentRequestDto.getUserid();
        this.todo = todo;

    }
}
