package com.yoga.yoga_tracker_service.Repository;

import com.yoga.yoga_tracker_service.Entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentRepository extends JpaRepository<Content,Long> {
    List<Content> findByIsPaidFalse();
    List<Content> findByIsPaidTrue();
}
