package com.yoga.yoga_tracker_service.Service;

import com.yoga.yoga_tracker_service.DTO.TrackerDTO;
import com.yoga.yoga_tracker_service.Entity.TrackerSession;
import com.yoga.yoga_tracker_service.Repository.TrackerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class TrackerService {
    private final TrackerRepository trackerRepository;
    @Autowired
    public TrackerService(TrackerRepository trackerRepository) {
        this.trackerRepository = trackerRepository;
    }

    public TrackerSession getTrackerByUserId(Long userId) {
        return trackerRepository.findById(userId).get();
    }

    public TrackerSession saveOrUpdateTracker(TrackerDTO trackerDTO) {
        TrackerSession session = TrackerSession.fromDTO(trackerDTO);
        return trackerRepository.save(session);
    }
}
