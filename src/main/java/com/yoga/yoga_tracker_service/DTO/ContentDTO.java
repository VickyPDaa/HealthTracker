package com.yoga.yoga_tracker_service.DTO;

import com.yoga.yoga_tracker_service.Entity.Content;


public class ContentDTO {

    private Long id;
    private String title;
    private String url;
    private String type;
    private boolean isPaid;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public ContentDTO(Long id, String title, String url, String type, boolean isPaid) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.type = type;
        this.isPaid = isPaid;
    }

    public static ContentDTO fromEntity(Content content) {
        return new ContentDTO(
                content.getId(),
                content.getTitle(),
                content.getUrl(),
                content.getType(),
                content.isPaid()
        );
    }
    public static Content toEntity(ContentDTO dto) {
        return new Content(
                dto.getId(),
                dto.getTitle(),
                dto.getUrl(),
                dto.getType(),
                dto.isPaid()
        );
    }
}

