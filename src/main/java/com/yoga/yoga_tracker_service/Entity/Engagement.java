package com.yoga.yoga_tracker_service.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "engagement")

public class Engagement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type; // MOTIVATION, FACT, QUIZ
    private String content;

    public Engagement() {
    }

    public Engagement(Long id, String type, String content) {
        this.id = id;
        this.type = type;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

