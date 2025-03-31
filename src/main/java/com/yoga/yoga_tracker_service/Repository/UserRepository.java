package com.yoga.yoga_tracker_service.Repository;

import com.yoga.yoga_tracker_service.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByusername(String username);

    Optional<User> findByEmail(String email);
}
