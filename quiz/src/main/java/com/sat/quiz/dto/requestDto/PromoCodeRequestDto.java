package com.sat.quiz.dto.requestDto;

import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
public class PromoCodeRequestDto {


    private Date startDate;

    private Boolean status;

    private Date endDate;

}
