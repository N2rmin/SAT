package com.sat.quiz.config;

import com.sat.quiz.service.impl.UserAuthServiceImpl;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserAuthServiceImpl userDetailsService;

//
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService).passwordEncoder(encodePWD());
        //.password("{noop}password").roles("ADMIN");
    }//
    @Override
    protected void configure(HttpSecurity http) throws Exception{

        http.csrf().disable();
        http.httpBasic().and()


                .authorizeRequests()
             .antMatchers("/results").permitAll()
                .antMatchers("/questions/questionForExam/**").permitAll()

//                .antMatchers("/examiner").permitAll()
//                .antMatchers("/questions/questionForExam/**").permitAll()
//                .and().authorizeRequests().anyRequest().authenticated();
                .antMatchers(HttpMethod.GET,"/questions/**").authenticated()
                .antMatchers(HttpMethod.POST,"/questions/**").authenticated()
                .antMatchers(HttpMethod.GET,"/textQuestions/**").authenticated()
                .antMatchers(HttpMethod.POST,"/textQuestions/**").authenticated()
                .antMatchers(HttpMethod.GET,"/answers/**").authenticated()
                .antMatchers(HttpMethod.POST,"/answers/**").authenticated()
                .antMatchers(HttpMethod.GET,"/modules/**").authenticated()
                .antMatchers(HttpMethod.POST,"/modules/**").authenticated()
                .antMatchers(HttpMethod.PUT,"/modules/**").authenticated()
                .antMatchers(HttpMethod.DELETE,"/modules/**").authenticated()
                .antMatchers(HttpMethod.GET,"/quizs/**").authenticated()
                .antMatchers(HttpMethod.PUT,"/quizs/**").authenticated()
                .antMatchers(HttpMethod.POST,"/quizs/**").authenticated()
                .antMatchers(HttpMethod.DELETE,"/quizs/**").authenticated()
                .antMatchers(HttpMethod.GET,"/sections/**").authenticated()
                .antMatchers(HttpMethod.PUT,"/sections/**").authenticated()
                .antMatchers(HttpMethod.POST,"/sections/**").authenticated()
                .antMatchers(HttpMethod.DELETE,"/sections/**").authenticated()

                .antMatchers(HttpMethod.POST,"/auth").authenticated();


                //.antMatchers("/login").authenticated()
              //  .antMatchers(HttpMethod.GET,"/").hasRole("User")



    }

    @Bean
    public BCryptPasswordEncoder encodePWD(){
        return new BCryptPasswordEncoder();
    }
}
