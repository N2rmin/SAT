package com.sat.quiz.dto.requestDto;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ResultRequestDto {


    private Map<Integer,Long> questionAnswer;
    private Map<Integer, String> openQuestionAnswer;
//    private Long questionId;
    private Long quizId;

    private Long moduleId;


    private Boolean status;
    private Long examinerId;
}
