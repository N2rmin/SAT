package com.sat.quiz.dto.responseDto;

import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
public class PromoCodeResponseDto {

    private  Long id;

    private String promoCode;

    private Date startDate;

    
    private Date endDate;

    private Boolean status;


}
