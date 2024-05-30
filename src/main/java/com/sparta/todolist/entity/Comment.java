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
    private Long commentid;
    @Column(name = "comment_txt", nullable = false)
    private String comment;
    @Column(name = "userid", nullable = false)
    private String userid;
    @Column(name = "id", nullable = false)
    private Long id;

    public Comment(CommentRequestDto commentRequestDto) {
        this.comment = commentRequestDto.getComment();
        this.userid = commentRequestDto.getUserid();
        this.id = commentRequestDto.getId();
    }
    public void update(CommentRequestDto commentRequestDto) {
        this.comment = commentRequestDto.getComment();
        this.userid = commentRequestDto.getUserid();
        this.id = commentRequestDto.getId();

    }

}
