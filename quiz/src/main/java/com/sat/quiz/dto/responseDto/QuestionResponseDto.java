package com.sat.quiz.dto.responseDto;

import com.sat.quiz.dto.AnswerDtoTest;
import com.sat.quiz.entity.Answer;
import com.sat.quiz.entity.Quiz;
import com.sat.quiz.entity.TextQuestion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionResponseDto {
    private Long id;
    private String questionText;
    //  private Long textQuestionId;
    private ModuleResponseDto module;
    private int orderNumber;
    // private List<String> textQuestionContext;
    private TextQuestionResponseDto textQuestion;
    private Boolean isOpen;
    private QuizResponseDto quiz;
    private List<AnswerResponseDto> answers;



}
