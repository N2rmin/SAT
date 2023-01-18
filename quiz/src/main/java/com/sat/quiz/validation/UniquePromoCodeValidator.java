package com.sat.quiz.validation;

import com.sat.quiz.entity.Examiner;
import com.sat.quiz.entity.Result;
import com.sat.quiz.repository.ExaminerRepository;
import com.sat.quiz.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniquePromoCodeValidator  implements ConstraintValidator<UniquePromoCode,String> {

    @Autowired
    ExaminerRepository examinerRepository;

    @Override
    public boolean isValid(String promoCode, ConstraintValidatorContext context) {
        Examiner examiner = examinerRepository.findByPromoCode(promoCode);
        return examiner == null;
    }
}