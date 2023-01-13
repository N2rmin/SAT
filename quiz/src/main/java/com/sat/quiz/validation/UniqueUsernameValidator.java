package com.sat.quiz.validation;

import com.sat.quiz.entity.Result;
import com.sat.quiz.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator  implements ConstraintValidator<UniqueUsername,String> {

    @Autowired
    ResultRepository resultRepository;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        Result result = resultRepository.findByUsername(username);
        return result == null;
    }
}