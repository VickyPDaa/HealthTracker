package com.yoga.yoga_tracker_service.Repository;

import com.yoga.yoga_tracker_service.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
