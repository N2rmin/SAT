package com.sat.quiz.dto.responseDto;

import com.sat.quiz.validation.UniquePromoCode;
import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@Data
public class ExaminerResponseDto {
    private Long id;

    private String name;

    private String lastName;
    private String promoCode;

    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
    //private Map<Long,String> answerText;
}
