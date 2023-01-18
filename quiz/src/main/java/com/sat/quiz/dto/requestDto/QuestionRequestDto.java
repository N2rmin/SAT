package com.sat.quiz.dto.requestDto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class QuestionRequestDto {
    private String questionText;
    private boolean status;
    private Long moduleId;
    private Long quizId;
    private Long textQuestionId;
}
