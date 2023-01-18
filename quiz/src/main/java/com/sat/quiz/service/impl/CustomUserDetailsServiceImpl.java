package com.sat.quiz.service.impl;

import com.sat.quiz.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

//
//@RequiredArgsConstructor
//public class CustomUserDetailsServiceImpl implements  UserDetailsService {
//
//    private final UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user= userRepository.findByUsername(username);
//        CustomUserDetailsImpl userDetails=null;
//        if(user!=null){
//            userDetails=new CustomUserDetailsImpl();
//            userDetails.setUser(user);
//        }else {
//            throw new UsernameNotFoundException("User not exist with name: +"+username);
//        }
//
//        return null;
//    }
//}
