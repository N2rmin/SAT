package com.sat.quiz.dto.requestDto;

import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
public class AnswerRequestDto {
    private String answerText;
    private Boolean status;
    private Boolean isTrue;
    private Long questionId;
    private Long variantId;


}
