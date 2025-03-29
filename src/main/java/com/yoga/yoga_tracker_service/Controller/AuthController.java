package com.yoga.yoga_tracker_service.Controller;

import com.yoga.yoga_tracker_service.Entity.User;
import com.yoga.yoga_tracker_service.Service.UserService;
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
    public User registerUser(@RequestBody User users) {
        return userService.registerUser(users);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User users) {
        return userService.loginUser(users);
    }

}
