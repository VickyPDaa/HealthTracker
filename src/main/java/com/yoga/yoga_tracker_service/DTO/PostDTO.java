package com.yoga.yoga_tracker_service.DTO;

import com.yoga.yoga_tracker_service.Entity.Post;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


public class PostDTO {

    private Long id;

    private String title;
    private String content;
    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<CommentDTO> getComments() {
        return comments;
    }

    public void setComments(List<CommentDTO> comments) {
        this.comments = comments;
    }

    private List<CommentDTO> comments;

    public PostDTO(Long id, String title, String content, LocalDateTime createdAt, List<CommentDTO> comments) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.comments = comments;
    }

    public static PostDTO fromEntity(Post post) {
        List<CommentDTO> commentDTOs = post.getComments().stream()
                .map(CommentDTO::fromEntity)
                .collect(Collectors.toList());
        return new PostDTO(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getCreatedAt(),
                commentDTOs
        );
}
}

