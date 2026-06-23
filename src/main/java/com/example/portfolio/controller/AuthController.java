package com.example.portfolio.controller;

import com.example.portfolio.dto.LoginDTO;
import com.example.portfolio.dto.UserRegistrationDTO;
import com.example.portfolio.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")

public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String registerUser(
            @RequestBody UserRegistrationDTO dto) {

        return userService.registerUser(dto);
    }

    @PostMapping("/login")
    public String loginUser(
            @RequestBody LoginDTO dto){

        return userService.loginUser(dto);
    }

}