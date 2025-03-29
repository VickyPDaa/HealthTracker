package com.yoga.yoga_tracker_service.DTO;

import com.yoga.yoga_tracker_service.Entity.Engagement;


public class EngagementDTO {

        private Long id;
        private String type;
        private String content;


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

    public EngagementDTO(Long id, String type, String content) {
        this.id = id;
        this.type = type;
        this.content = content;
    }

    public static EngagementDTO fromEntity(Engagement engagement) {
            return new EngagementDTO(
                    engagement.getId(),
                    engagement.getType(),
                    engagement.getContent()
            );
        }

    public static Engagement toEntity(EngagementDTO engagementDTO) {
        return new Engagement(engagementDTO.getId(),engagementDTO.getType(),engagementDTO.getContent());
    }

}