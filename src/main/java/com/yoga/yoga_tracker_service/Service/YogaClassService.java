package com.yoga.yoga_tracker_service.Service;

import com.yoga.yoga_tracker_service.DTO.YogaClassDTO;
import com.yoga.yoga_tracker_service.Entity.TrackerSession;
import com.yoga.yoga_tracker_service.Entity.YogaClass;
import com.yoga.yoga_tracker_service.Repository.YogaClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class YogaClassService {
    @Autowired
    public YogaClassService(YogaClassRepository yogaClassRepository) {
        this.yogaClassRepository = yogaClassRepository;
    }

    private final YogaClassRepository yogaClassRepository;
    public List<YogaClassDTO> getUpcomingClasses() {
       return yogaClassRepository.findByIsActiveTrue().stream().map(YogaClassDTO::fromEntity).toList();
    }

    public YogaClassDTO getClassById(Long id) {
        return yogaClassRepository.findById(id)
                .map(YogaClassDTO::fromEntity)
                .orElse(null);
    }

    public YogaClass addClasses(YogaClassDTO yogaClassDTO) {
        YogaClass yogaClass = YogaClass.fromDTO(yogaClassDTO);
        return yogaClassRepository.save(yogaClass);
    }
}
