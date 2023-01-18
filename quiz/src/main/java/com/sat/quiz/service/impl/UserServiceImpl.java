package com.sat.quiz.service.impl;

import com.sat.quiz.dto.requestDto.UserRequestDto;
import com.sat.quiz.entity.Users;
import com.sat.quiz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl {


    UserRepository userRepository;

    PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder=  new BCryptPasswordEncoder();
    }

    public void save(UserRequestDto user) {
        Users userself= new Users();
        userself.setUsername(user.getUsername());
        userself.setPassword(user.getPassword());
       userself.setPassword(this.passwordEncoder.encode(userself.getPassword()));
        userRepository.save(userself);
    }
//
//    public Page<User> getUsers(Pageable page) {
//        return userRepository.findAll(page);
//    }

}
