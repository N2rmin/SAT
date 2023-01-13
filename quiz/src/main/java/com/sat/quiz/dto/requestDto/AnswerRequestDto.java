package com.sat.quiz.dto.requestDto;

import lombok.Data;

import java.util.List;

@Data
public class AnswerRequestDto {
    private String answerText;
    private Boolean status;
    private Boolean isTrue;
    private Long questionId;


}
