package com.yoga.yoga_tracker_service.Controller;

import com.yoga.yoga_tracker_service.DTO.ContentDTO;
import com.yoga.yoga_tracker_service.Service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/content")

public class ContentController {

    private final ContentService contentService;
    @Autowired
    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @GetMapping
    public ResponseEntity<List<ContentDTO>> getAllContent() {
        List<ContentDTO> content = contentService.getAllContent();
        return ResponseEntity.ok(content);
    }

    @GetMapping("/free")
    public ResponseEntity<List<ContentDTO>> getFreeContent() {
        List<ContentDTO> content = contentService.getFreeContent();
        return ResponseEntity.ok(content);
    }

    @GetMapping("/paid")
    public ResponseEntity<List<ContentDTO>> getPaidContent() {
        List<ContentDTO> content = contentService.getPaidContent();
        return ResponseEntity.ok(content);
    }

    @PostMapping
    public ResponseEntity<ContentDTO> addNewContent(@RequestBody ContentDTO contentDTO) {
        ContentDTO savedContent = contentService.addNewContent(contentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedContent);
    }
}

