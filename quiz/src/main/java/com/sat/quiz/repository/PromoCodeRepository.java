package com.sat.quiz.repository;

import com.sat.quiz.entity.Examiner;
import com.sat.quiz.entity.PromoCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedQuery;
import java.util.List;

@Repository
public interface PromoCodeRepository extends JpaRepository<PromoCode,Long> {

PromoCode findByPromoCode(String promoCode);

    @Query(value = "select * from promo_code where promo_code .start_date is not null and status=true order by id asc limit 50", nativeQuery = true)
    List<PromoCode> findTopByIdAndStatusTrueAndStartDateIsNotNull(Long id);
    @Query(value = "select * from promo_code where promo_code .start_date isnull  and status=true order by id asc limit 50", nativeQuery = true)
    List<PromoCode> findFirst50AndStatusTrueAndStartDateIsNullByOrderByIdAsc();

}
