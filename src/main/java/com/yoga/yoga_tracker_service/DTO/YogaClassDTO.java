package com.yoga.yoga_tracker_service.DTO;

import com.yoga.yoga_tracker_service.Entity.ClassParticipant;
import com.yoga.yoga_tracker_service.Entity.YogaClass;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class YogaClassDTO {
    private Long id;
    private String title;
    private String instructor;
    private LocalDateTime startTime;
    private String type; // Group, Personal, VIP
    private boolean isActive;
    private List<ClassParticipantDTO> participants;

    public YogaClassDTO() {
    }

    public YogaClassDTO(Long id, String title, String instructor, LocalDateTime startTime, String type, boolean isActive, List<ClassParticipantDTO> participants) {
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

    public List<ClassParticipantDTO> getParticipants() {
        return participants;
    }

    public void setParticipants(List<ClassParticipantDTO> participants) {
        this.participants = participants;
    }

    // Convert Entity to DTO
    public static YogaClassDTO fromEntity(YogaClass yogaClass) {
        List<ClassParticipantDTO> participantDTOs = (yogaClass.getParticipants() != null)
                ? yogaClass.getParticipants().stream()
                .map(ClassParticipantDTO::fromEntity)
                .collect(Collectors.toList())
                : null;

        return new YogaClassDTO(
                yogaClass.getId(),
                yogaClass.getTitle(),
                yogaClass.getInstructor(),
                yogaClass.getStartTime(),
                yogaClass.getType(),
                yogaClass.isActive(),
                participantDTOs
        );
    }

    // Convert DTO to Entity
    public static YogaClass toEntity(YogaClassDTO yogaClassDTO) {
        YogaClass yogaClass = new YogaClass();
        yogaClass.setId(yogaClassDTO.getId());
        yogaClass.setTitle(yogaClassDTO.getTitle());
        yogaClass.setInstructor(yogaClassDTO.getInstructor());
        yogaClass.setStartTime(yogaClassDTO.getStartTime());
        yogaClass.setType(yogaClassDTO.getType());
        yogaClass.setActive(yogaClassDTO.isActive());

        if (yogaClassDTO.getParticipants() != null) {
            List<ClassParticipant> participants = yogaClassDTO.getParticipants().stream()
                    .map(participantDTO -> ClassParticipantDTO.toEntity(participantDTO, yogaClass))
                    .collect(Collectors.toList());
            yogaClass.setParticipants(participants);
        }

        return yogaClass;
    }
}
