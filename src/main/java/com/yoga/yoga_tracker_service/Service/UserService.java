package com.yoga.yoga_tracker_service.Service;

import com.yoga.yoga_tracker_service.DTO.UserDTO;
import com.yoga.yoga_tracker_service.Entity.Role;
import com.yoga.yoga_tracker_service.Entity.User;
import com.yoga.yoga_tracker_service.Repository.UserRepository;
import com.yoga.yoga_tracker_service.SecurityService.MyUserDetailService;
import com.yoga.yoga_tracker_service.Utility.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
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
    @Autowired
    private MyUserDetailService userDetailService;
    @Autowired
    JwtUtil jwtUtil;
    @Autowired EmailService emailService;


    public UserDTO registerUser(UserDTO userDTO) {
        if (userRepository.findByEmail(userDTO.getEmail()).isPresent()) {
            throw new RuntimeException("User with this email already exists!");
        }

        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(encoder.encode(userDTO.getPassword())); // Encrypt password
        user.setRole(userDTO.getRole()); // Default role
        System.out.println(user.getUsername()+" "+user.getPassword());

        User savedUser = userRepository.save(user);

        // ✅ Step 4: Send welcome email
        emailService.sendWelcomeEmail(savedUser.getEmail(), savedUser.getUsername());

        return new UserDTO(savedUser.getUsername(),savedUser.getEmail(),savedUser.getPassword(),savedUser.getRole());
    }

    public String loginUser(User users) {
        User dbUser = userRepository.findByusername(users.getUsername());
        if (dbUser == null) {
            return "User not found";
        }

        Authentication authentication= manager.authenticate(
                new UsernamePasswordAuthenticationToken(users.getUsername(),users.getPassword()));
        if (authentication.isAuthenticated()){
            System.out.println("Token authenticated vivek");
            UserDetails userDetails = userDetailService.loadUserByUsername(users.getUsername());
            return jwtUtil.generateToken(userDetails);
        } else {
            return "Failure";
        }
    }
}
