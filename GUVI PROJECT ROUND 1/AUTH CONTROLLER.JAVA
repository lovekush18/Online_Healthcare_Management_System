package com.healthcarepro.controller;

import com.healthcarepro.model.User;
import com.healthcarepro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        if (userRepository.findByEmail(user.getEmail()) != null)
            return "Email already exists";

        userRepository.save(user);
        return "Registration successful";
    }

    @PostMapping("/login")
    public User login(@RequestBody User loginData) {
        User u = userRepository.findByEmail(loginData.getEmail());
        if (u != null && u.getPassword().equals(loginData.getPassword())) {
            return u;
        }
        return null;
    }
}
