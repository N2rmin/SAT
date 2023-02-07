package com.sat.quiz.repository;

import com.sat.quiz.entity.Examiner;
import com.sat.quiz.entity.PromoCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromoCodeRepository extends JpaRepository<PromoCode,Long> {

PromoCode findByPromoCode(String promoCode);

    List<PromoCode> findTopByIdAndStartDateIsNotNull(Long id);
    List<PromoCode> findFirst50AndStartDateIsNullByOrderByIdAsc();

}
