package com.yoga.yoga_tracker_service.DTO;

import com.yoga.yoga_tracker_service.Entity.TrackerSession;

import java.util.Date;


public class TrackerDTO {

    private Long id;
    private Long userId;
    private String level;
    private int completedSessions;
    private String nextRecommended;

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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getCompletedSessions() {
        return completedSessions;
    }

    public void setCompletedSessions(int completedSessions) {
        this.completedSessions = completedSessions;
    }

    public String getNextRecommended() {
        return nextRecommended;
    }

    public void setNextRecommended(String nextRecommended) {
        this.nextRecommended = nextRecommended;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    private Date lastUpdated;

    public TrackerDTO(Long id,Long userId, String level, int completedSessions, String nextRecommended, Date lastUpdated) {
        this.id = id;
        this.userId = userId;
        this.level = level;
        this.completedSessions = completedSessions;
        this.nextRecommended = nextRecommended;
        this.lastUpdated = lastUpdated;
    }

    public static TrackerDTO fromEntity(TrackerSession session) {
        return new TrackerDTO(
                session.getId(),
                session.getUserId(),
                session.getLevel(),
                session.getCompletedSessions(),
                session.getNextRecommended(),
                session.getLastUpdated()
        );
    }
}
