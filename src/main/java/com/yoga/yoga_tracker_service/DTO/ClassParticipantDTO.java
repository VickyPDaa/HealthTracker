package com.yoga.yoga_tracker_service.DTO;


import com.yoga.yoga_tracker_service.Entity.ClassParticipant;
import com.yoga.yoga_tracker_service.Entity.YogaClass;

public class ClassParticipantDTO {
    private Long id;
    private Long userId;
    private Long yogaClassId;
    private boolean hasJoined;

    public ClassParticipantDTO() {
    }

    public ClassParticipantDTO(Long id, Long userId, Long yogaClassId, boolean hasJoined) {
        this.id = id;
        this.userId = userId;
        this.yogaClassId = yogaClassId;
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

    public Long getYogaClassId() {
        return yogaClassId;
    }

    public void setYogaClassId(Long yogaClassId) {
        this.yogaClassId = yogaClassId;
    }

    public boolean isHasJoined() {
        return hasJoined;
    }

    public void setHasJoined(boolean hasJoined) {
        this.hasJoined = hasJoined;
    }

    // Convert Entity to DTO
    public static ClassParticipantDTO fromEntity(ClassParticipant participant) {
        return new ClassParticipantDTO(
                participant.getId(),
                participant.getUserId(),
                participant.getYogaClass().getId(),
                participant.isHasJoined()
        );
    }

    // Convert DTO to Entity
    public static ClassParticipant toEntity(ClassParticipantDTO participantDTO, YogaClass yogaClass) {
        ClassParticipant participant = new ClassParticipant();
        participant.setId(participantDTO.getId());
        participant.setUserId(participantDTO.getUserId());
        participant.setYogaClass(yogaClass);
        participant.setHasJoined(participantDTO.isHasJoined());
        return participant;
    }
}
