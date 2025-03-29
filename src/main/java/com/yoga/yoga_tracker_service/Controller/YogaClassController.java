package com.yoga.yoga_tracker_service.Controller;

import com.yoga.yoga_tracker_service.DTO.TrackerDTO;
import com.yoga.yoga_tracker_service.DTO.YogaClassDTO;
import com.yoga.yoga_tracker_service.Entity.TrackerSession;
import com.yoga.yoga_tracker_service.Entity.YogaClass;
import com.yoga.yoga_tracker_service.Service.YogaClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classes")

public class YogaClassController {
    @Autowired
    public YogaClassController(YogaClassService yogaClassService) {
        this.yogaClassService = yogaClassService;
    }

    private final YogaClassService yogaClassService;

    @GetMapping("/upcoming")
    public ResponseEntity<List<YogaClassDTO>> getUpcomingClasses() {
        List<YogaClassDTO> classes = yogaClassService.getUpcomingClasses();
        return ResponseEntity.ok(classes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<YogaClassDTO> getClassById(@PathVariable Long id) {
        YogaClassDTO yogaClass = yogaClassService.getClassById(id);
        return yogaClass != null ? ResponseEntity.ok(yogaClass) : ResponseEntity.notFound().build();
    }

    @PostMapping("/{id}")
    public ResponseEntity<YogaClassDTO> addClasses(@RequestBody YogaClassDTO yogaClassDTO) {
        YogaClass yogaClass = yogaClassService.addClasses(yogaClassDTO);
        return ResponseEntity.ok(YogaClassDTO.fromEntity(yogaClass));
    }
}