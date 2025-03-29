package com.yoga.yoga_tracker_service.Repository;

import com.yoga.yoga_tracker_service.Entity.TrackerSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackerRepository extends JpaRepository<TrackerSession, Long> {
}
