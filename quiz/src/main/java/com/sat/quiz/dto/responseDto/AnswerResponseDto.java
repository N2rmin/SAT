package com.sat.quiz.dto.responseDto;

import lombok.Data;

import java.util.List;

@Data
public class AnswerResponseDto {
    private Long id;
    private String answerText;
    private Boolean status;
    private Boolean isTrue;
    private List<String> questionText;
    //private List<String> textQuestionContext;
    

}
