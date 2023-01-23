package com.sat.quiz.validation;

import com.sat.quiz.entity.Examiner;
import com.sat.quiz.repository.ExaminerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniquePromoCodeValidator  implements ConstraintValidator<UniquePromoCode,String> {

    @Autowired
    ExaminerRepository examinerRepository;

    @Override
    public boolean isValid(String promoCode, ConstraintValidatorContext context) {
        System.out.println("11111");
        Examiner examiner = examinerRepository.findByPromoCode(promoCode);
        System.out.println("22222");

        return examiner == null;
    }
}