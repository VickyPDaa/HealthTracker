package com.yoga.yoga_tracker_service.Repository;

import com.yoga.yoga_tracker_service.Entity.YogaClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface YogaClassRepository extends JpaRepository<YogaClass, Long> {
    List<YogaClass> findByIsActiveTrue();
}
