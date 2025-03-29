package com.yoga.yoga_tracker_service.Entity;

import com.yoga.yoga_tracker_service.DTO.TrackerDTO;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tracker_sessions")

public class TrackerSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId; // Assuming User exists
    private String level; // Beginner, Intermediate, Advanced
    private int completedSessions;
    private String nextRecommended;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;

    public TrackerSession() {
    }

    public TrackerSession(Long id, Long userId, String level, int completedSessions, String nextRecommended, Date lastUpdated) {
        this.id = id;
        this.userId = userId;
        this.level = level;
        this.completedSessions = completedSessions;
        this.nextRecommended = nextRecommended;
        this.lastUpdated = lastUpdated;
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
    public static TrackerSession fromDTO(TrackerDTO session) {
        return new TrackerSession(session.getId(), session.getUserId(), session.getLevel(), session.getCompletedSessions(), session.getNextRecommended(), session.getLastUpdated()
        );
    }
}
