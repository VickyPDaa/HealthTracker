package com.yoga.yoga_tracker_service.Service;

import com.yoga.yoga_tracker_service.Entity.User;
import com.yoga.yoga_tracker_service.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    AuthenticationManager manager;
    @Autowired
    UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder encoder;


    public User registerUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public String loginUser(User users) {
        User dbUser = userRepository.findByusername(users.getUsername());
        if (dbUser == null) {
            return "User not found";
        }

        Authentication authentication= manager.authenticate(
                new UsernamePasswordAuthenticationToken(dbUser.getUsername(),dbUser.getPassword()));
        if (authentication.isAuthenticated()){
            return "Success";
        } else {
            return "Failure";
        }
    }
}
