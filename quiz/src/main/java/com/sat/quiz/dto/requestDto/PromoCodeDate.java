package com.sat.quiz.dto.requestDto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PromoCodeDate {
   List< Long> promoCodeIds;
    private Date startDate;

}
