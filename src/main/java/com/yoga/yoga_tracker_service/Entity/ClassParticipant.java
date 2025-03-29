package com.yoga.yoga_tracker_service.Entity;

import jakarta.persistence.*;
@Entity
@Table(name = "class_participants")
public class ClassParticipant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    private YogaClass yogaClass;

    private boolean hasJoined;

    public ClassParticipant() {
    }

    public ClassParticipant(Long id, Long userId, YogaClass yogaClass, boolean hasJoined) {
        this.id = id;
        this.userId = userId;
        this.yogaClass = yogaClass;
        this.hasJoined = hasJoined;
    }

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

    public YogaClass getYogaClass() {
        return yogaClass;
    }

    public void setYogaClass(YogaClass yogaClass) {
        this.yogaClass = yogaClass;
    }

    public boolean isHasJoined() {
        return hasJoined;
    }

    public void setHasJoined(boolean hasJoined) {
        this.hasJoined = hasJoined;
    }
}
