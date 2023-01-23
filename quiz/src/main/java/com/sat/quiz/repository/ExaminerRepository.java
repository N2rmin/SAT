package com.sat.quiz.repository;

import com.sat.quiz.entity.Examiner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExaminerRepository extends JpaRepository<Examiner,Long> {

    Examiner findByPromoCode(String promoCode);

}
