package com.sat.quiz.dto.responseDto;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ExamResponseDto {
    private Map<Long,Object> questionAnswer;


    //private Map<Long,String> answerText;
}
