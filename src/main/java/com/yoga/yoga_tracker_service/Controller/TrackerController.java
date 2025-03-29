package com.yoga.yoga_tracker_service.Controller;

import com.yoga.yoga_tracker_service.DTO.TrackerDTO;
import com.yoga.yoga_tracker_service.Entity.TrackerSession;
import com.yoga.yoga_tracker_service.Service.TrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tracker")

public class TrackerController {
    private final TrackerService trackerService;
    @Autowired
    public TrackerController(TrackerService trackerService) {
        this.trackerService = trackerService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<TrackerDTO> getUserProgress(@PathVariable Long userId) {
        TrackerSession session = trackerService.getTrackerByUserId(userId);
        return session != null ? ResponseEntity.ok(TrackerDTO.fromEntity(session))
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<TrackerDTO> saveUserProgress(@RequestBody TrackerDTO trackerDTO) {
        TrackerSession savedSession = trackerService.saveOrUpdateTracker(trackerDTO);
        return ResponseEntity.ok(TrackerDTO.fromEntity(savedSession));
    }

}
