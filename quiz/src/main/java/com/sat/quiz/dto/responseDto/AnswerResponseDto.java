package com.sat.quiz.dto.responseDto;

import com.sat.quiz.entity.Question;
import lombok.Data;

import java.util.List;

@Data
public class AnswerResponseDto {
    private Long id;
    private String answerText;
    private Boolean status;
    private Boolean isTrue;
   // private QuestionResponseDto question;
    //private List<String> textQuestionContext;
    

}
