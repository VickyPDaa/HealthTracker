package com.yoga.yoga_tracker_service.Service;

import com.yoga.yoga_tracker_service.DTO.EngagementDTO;
import com.yoga.yoga_tracker_service.Entity.Engagement;
import com.yoga.yoga_tracker_service.Repository.EngagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class EngagementService {
    @Autowired
    public EngagementService(EngagementRepository engagementRepository) {
        this.engagementRepository = engagementRepository;
    }

    private final EngagementRepository engagementRepository;

    public EngagementDTO getRandomMotivation() {
        List<Engagement> results = engagementRepository.findRandomByType("MOTIVATION", PageRequest.of(0, 1));
        return results.isEmpty() ? null : EngagementDTO.fromEntity(results.get(0));
    }

    public EngagementDTO getRandomFact() {
        List<Engagement> results = engagementRepository.findRandomByType("FACT", PageRequest.of(0, 1));
        return results.isEmpty() ? null : EngagementDTO.fromEntity(results.get(0));
    }

    public List<EngagementDTO> getAllQuizzes() {
        return engagementRepository.findRandomByType("QUIZ", PageRequest.of(0, 10))
                .stream()
                .map(EngagementDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public EngagementDTO addNewEngagement(EngagementDTO engagementDTO) {
        Engagement engagement = EngagementDTO.toEntity(engagementDTO);
        engagement = engagementRepository.save(engagement);
        return EngagementDTO.fromEntity(engagement);
    }
}
