package com.example.portfolio.service;

import com.example.portfolio.dto.LoginDTO;
import com.example.portfolio.dto.UserRegistrationDTO;
import com.example.portfolio.entity.User;
import com.example.portfolio.repository.UserRepository;
import com.example.portfolio.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;


    public String registerUser(UserRegistrationDTO dto) {

        if(userRepository.findByEmail(dto.getEmail()).isPresent()) {
            return "Email already exists";
        }

        User user = new User();

        user.setFullName(dto.getFullName());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setCompanyName(dto.getCompanyName());
        user.setDesignation(dto.getDesignation());
        user.setRole(dto.getRole());

        userRepository.save(user);

        return "Registration Successful";
    }

    public String loginUser(LoginDTO dto){

        Optional<User> user =
                userRepository.findByEmail(dto.getEmail());

        if(user.isEmpty()){
            return "User Not Found";
        }

        if(!passwordEncoder.matches(
                dto.getPassword(),
                user.get().getPassword()
        )){
            return "Invalid Password";
        }

        String token =
                jwtUtil.generateToken(dto.getEmail(), user.get().getRole());

        return token;
    }



}