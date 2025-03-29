package com.yoga.yoga_tracker_service.DTO;

import com.yoga.yoga_tracker_service.Entity.CommunityPost;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class CommunityPostDTO {

    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private List<CommentDTO> comments;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public List<CommentDTO> getComments() {
        return comments;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setComments(List<CommentDTO> comments) {
        this.comments = comments;
    }


    public CommunityPostDTO(Long id, String title, String content, LocalDateTime createdAt, List<CommentDTO> comments) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.comments = comments;
    }

    public static CommunityPostDTO fromEntity(CommunityPost post) {
        List<CommentDTO> commentDTOs = (post.getComments() != null)
                ? post.getComments().stream()
                .map(CommentDTO::fromEntity)
                .collect(Collectors.toList())
                : new ArrayList<>(); // Handle null case
        return new CommunityPostDTO(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getCreatedAt(),
                commentDTOs
        );
    }
}
