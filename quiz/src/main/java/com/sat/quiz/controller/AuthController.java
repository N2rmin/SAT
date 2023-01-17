package com.sat.quiz.controller;

import com.fasterxml.jackson.annotation.JsonView;

import com.sat.quiz.entity.Users;
import com.sat.quiz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    UserRepository userRepository;


    @PostMapping("/api/1.0/auth")
    ResponseEntity<?> handleAuthentication( Users user){







        return ResponseEntity.ok(user);

    }
}
