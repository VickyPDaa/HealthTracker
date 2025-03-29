package com.yoga.yoga_tracker_service.Repository;

import com.yoga.yoga_tracker_service.Entity.Engagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EngagementRepository extends JpaRepository<Engagement,Long> {
    @Query("SELECT e FROM Engagement e WHERE e.type = :type ORDER BY FUNCTION('RAND')")
    List<Engagement> findRandomByType(@Param("type") String type, Pageable pageable);
}
