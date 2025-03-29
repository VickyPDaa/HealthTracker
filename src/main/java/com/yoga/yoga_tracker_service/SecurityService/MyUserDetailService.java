package com.yoga.yoga_tracker_service.SecurityService;

import com.yoga.yoga_tracker_service.Entity.User;
import com.yoga.yoga_tracker_service.Entity.UserDetailsWrapper;
import com.yoga.yoga_tracker_service.Repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    public MyUserDetailService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByusername(username);
        if (user == null){
            System.out.println("User not found");
        }
        return new UserDetailsWrapper(user);
    }
}
