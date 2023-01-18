package com.sat.quiz.service.impl;

import com.sat.quiz.entity.Users;
import com.sat.quiz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@ComponentScan("com.sat.quiz.*")
public class UserAuthServiceImpl implements UserDetailsService {


    final
    UserRepository userRepository;

    public UserAuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users inDB = userRepository.findByUsername(username);

        if(inDB==null)
            throw  new UsernameNotFoundException("user not found");
        return inDB;

    }
}
