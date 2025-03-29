package com.yoga.yoga_tracker_service.Controller;

import com.yoga.yoga_tracker_service.DTO.EngagementDTO;
import com.yoga.yoga_tracker_service.Service.EngagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/engagement")

public class EngagementController {

    private final EngagementService engagementService;

    @Autowired
    public EngagementController(EngagementService engagementService) {
        this.engagementService = engagementService;
    }

    @GetMapping("/motivation")
    public ResponseEntity<EngagementDTO> getMotivation() {
        EngagementDTO motivation = engagementService.getRandomMotivation();
        return motivation != null ? ResponseEntity.ok(motivation) : ResponseEntity.notFound().build();
    }

    @GetMapping("/fact")
    public ResponseEntity<EngagementDTO> getFact() {
        EngagementDTO fact = engagementService.getRandomFact();
        return fact != null ? ResponseEntity.ok(fact) : ResponseEntity.notFound().build();
    }

    @GetMapping("/quizzes")
    public ResponseEntity<List<EngagementDTO>> getQuizzes() {
        List<EngagementDTO> quizzes = engagementService.getAllQuizzes();
        return ResponseEntity.ok(quizzes);
    }

    @PostMapping
    public ResponseEntity<EngagementDTO> addNewEngagement(@RequestBody EngagementDTO engagementDTO) {
        EngagementDTO savedEngagement = engagementService.addNewEngagement(engagementDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEngagement);
    }
}

