package com.sat.quiz.dto.responseDto;

import lombok.Data;

import java.util.Map;

@Data
public class TextQuestionResponseDto {
    private Long id;
    private String textContent;
    private boolean status;

    private Map<Long,String> questions;

    private Map<Long,String> answerText;

    private Map<String,Object> questionAnswer;

}
