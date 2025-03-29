package com.yoga.yoga_tracker_service.Service;

import com.yoga.yoga_tracker_service.DTO.ContentDTO;
import com.yoga.yoga_tracker_service.Entity.Content;
import com.yoga.yoga_tracker_service.Repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class ContentService {
    private final ContentRepository contentRepository;
    @Autowired
    public ContentService(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    public List<ContentDTO> getAllContent() {
       return contentRepository.findAll().stream().map(ContentDTO::fromEntity)
               .collect(Collectors.toList());
    }

    public List<ContentDTO> getFreeContent() {
        return contentRepository.findByIsPaidFalse().stream().map(ContentDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public List<ContentDTO> getPaidContent() {
        return contentRepository.findByIsPaidTrue().stream().map(ContentDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public ContentDTO addNewContent(ContentDTO contentDTO) {
        Content content = ContentDTO.toEntity(contentDTO);
        content = contentRepository.save(content);
        return ContentDTO.fromEntity(content);
    }
}
