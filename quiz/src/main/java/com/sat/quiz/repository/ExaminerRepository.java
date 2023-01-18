package com.sat.quiz.repository;

import com.sat.quiz.entity.Examiner;
import com.sat.quiz.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExaminerRepository extends JpaRepository<Examiner,Long> {

    Examiner findByPromoCode(String promoCode);

}
