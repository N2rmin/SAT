package com.sat.quiz.dto.requestDto;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ResultRequestDto {


    private Map<Long,Long> questionAnswer;
//    private Long questionId;
    private Long quizId;

    private Boolean status;
    private String username;
}
