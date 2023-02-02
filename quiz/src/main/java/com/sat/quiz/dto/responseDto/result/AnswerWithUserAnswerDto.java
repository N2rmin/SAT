package com.sat.quiz.dto.responseDto.result;

import com.sat.quiz.dto.responseDto.VariantResponseDto;

public class AnswerWithUserAnswerDto {
    private Long id;
    private String answerText;
    private Boolean status;
    private Boolean isTrue;
    private VariantResponseDto variant;
    private Long userAnswerId;
}
