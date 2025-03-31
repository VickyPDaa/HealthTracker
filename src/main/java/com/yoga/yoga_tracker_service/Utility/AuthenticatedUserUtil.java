package com.yoga.yoga_tracker_service.Utility;

import com.yoga.yoga_tracker_service.Entity.UserDetailsWrapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticatedUserUtil {
    public static Long getLoggedInUserId() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetailsWrapper) {
            return ((UserDetailsWrapper) principal).getId();
        }
        return null; // User not authenticated
    }
}
