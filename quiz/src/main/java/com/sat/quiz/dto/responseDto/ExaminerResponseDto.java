package com.sat.quiz.dto.responseDto;

import com.sat.quiz.validation.UniquePromoCode;
import lombok.Data;

import java.util.List;

@Data
public class ExaminerResponseDto {
    private Long id;

    private String name;

    private String lastName;
    private String promoCode;

    //private Map<Long,String> answerText;
}
