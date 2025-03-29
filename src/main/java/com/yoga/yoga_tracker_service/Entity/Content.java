package com.yoga.yoga_tracker_service.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "content")


public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String url;
    private String type; // PDF, Video, Course
    private boolean isPaid;

    public Content() {
    }

    public Content(Long id, String title, String url, String type, boolean isPaid) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.type = type;
        this.isPaid = isPaid;
    }

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
}