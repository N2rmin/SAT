package com.sat.quiz.dto;

import lombok.Data;

@Data
public class AnswerDtoTest {

    private Long id;

    private String answerText;
    private Boolean status;

    private Boolean isTrue;
}
