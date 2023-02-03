package com.sat.quiz.dto.responseDto;

import lombok.Data;

import java.util.Date;

@Data
public class PromoCodeResponseDto {

    private  Long id;

    private String promoCode;

    private Date startDate;

    private Boolean status;


}
