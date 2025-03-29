package com.yoga.yoga_tracker_service.Entity;

import com.yoga.yoga_tracker_service.DTO.CommentDTO;
import com.yoga.yoga_tracker_service.DTO.YogaClassDTO;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity

@Table(name = "classes")
public class YogaClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String instructor;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime startTime;

    private String type; // Group, Personal, VIP
    private boolean isActive;

    @OneToMany(mappedBy = "yogaClass", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ClassParticipant> participants = new ArrayList<>();

    public YogaClass() {
    }

    public YogaClass(Long id, String title, String instructor, LocalDateTime startTime, String type, boolean isActive, List<ClassParticipant> participants) {
        this.id = id;
        this.title = title;
        this.instructor = instructor;
        this.startTime = startTime;
        this.type = type;
        this.isActive = isActive;
        this.participants = participants;
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

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<ClassParticipant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<ClassParticipant> participants) {
        this.participants = participants;
    }


    public static YogaClass fromDTO(YogaClassDTO yogaClassDTO) {
        YogaClass yogaClass = new YogaClass(
                yogaClassDTO.getId(),
                yogaClassDTO.getTitle(),
                yogaClassDTO.getInstructor(),
                yogaClassDTO.getStartTime(),
                yogaClassDTO.getType(),
                yogaClassDTO.isActive(),
                new ArrayList<>()
        );

        if (yogaClassDTO.getParticipants() != null) {
            List<ClassParticipant> participantEntities = yogaClassDTO.getParticipants().stream()
                    .map(participantDTO -> {
                        ClassParticipant participant = new ClassParticipant();
                        participant.setUserId(participantDTO.getUserId());
                        participant.setHasJoined(participantDTO.isHasJoined());
                        participant.setYogaClass(yogaClass); // Set reference to the parent class
                        return participant;
                    })
                    .collect(Collectors.toList());

            yogaClass.setParticipants(participantEntities);
        }


        return yogaClass;
    }
}
