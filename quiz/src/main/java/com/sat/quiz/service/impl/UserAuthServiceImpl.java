package com.sat.quiz.service.impl;

import com.sat.quiz.entity.Users;
import com.sat.quiz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserAuthServiceImpl implements UserDetailsService {


    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users inDB = userRepository.findByUsername(username);

        if(inDB==null)
            throw  new UsernameNotFoundException("user not found");
        return inDB;

    }
}
