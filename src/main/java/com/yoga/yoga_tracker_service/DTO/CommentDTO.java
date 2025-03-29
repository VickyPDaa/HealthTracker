package com.yoga.yoga_tracker_service.DTO;

import com.yoga.yoga_tracker_service.Entity.Comment;

import java.util.Date;


public class CommentDTO {

    private Long id;
    private Long userId;
    private String content;
    private Date commentedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCommentedAt() {
        return commentedAt;
    }

    public void setCommentedAt(Date commentedAt) {
        this.commentedAt = commentedAt;
    }



    public CommentDTO(Long id, Long userId, String content, Date commentedAt) {
        this.id = id;
        this.userId = userId;
        this.content = content;
        this.commentedAt = commentedAt;
    }

    public static CommentDTO fromEntity(Comment comment) {
        return new CommentDTO(
                comment.getId(),
                comment.getUserId(),
                comment.getContent(),
                comment.getCommentedAt()
        );
    }
}

