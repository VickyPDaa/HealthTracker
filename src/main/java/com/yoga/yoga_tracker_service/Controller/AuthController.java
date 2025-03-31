package com.yoga.yoga_tracker_service.Controller;

import com.yoga.yoga_tracker_service.DTO.UserDTO;
import com.yoga.yoga_tracker_service.Entity.User;
import com.yoga.yoga_tracker_service.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public UserDTO registerUser(@Valid @RequestBody UserDTO user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {
        return userService.loginUser(user);
    }

}
