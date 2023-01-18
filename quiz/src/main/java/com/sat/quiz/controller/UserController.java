package com.sat.quiz.controller;


import com.sat.quiz.dto.requestDto.UserRequestDto;
import com.sat.quiz.dto.responseDto.QuestionResponseDto;
import com.sat.quiz.dto.responseDto.UserResponseDto;
import com.sat.quiz.entity.Users;
import com.sat.quiz.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RestController
public class UserController {

    @Autowired//Dependency Injection
    UserServiceImpl userService;

    @CrossOrigin
    @PostMapping("/api/1.0/users")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity createUser(@Valid @RequestBody UserRequestDto user){

        userService.save(user);
        return  ResponseEntity.ok(user);
    }
}
