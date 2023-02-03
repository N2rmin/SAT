package com.sat.quiz.repository;

import com.sat.quiz.entity.Examiner;
import com.sat.quiz.entity.PromoCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromoCodeRepository extends JpaRepository<PromoCode,Long> {

PromoCode findByPromoCode(String promoCode);
}
