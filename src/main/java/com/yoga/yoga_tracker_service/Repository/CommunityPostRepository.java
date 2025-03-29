package com.yoga.yoga_tracker_service.Repository;

import com.yoga.yoga_tracker_service.Entity.CommunityPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
@Repository
public interface CommunityPostRepository extends  JpaRepository<CommunityPost,Long> {

}
