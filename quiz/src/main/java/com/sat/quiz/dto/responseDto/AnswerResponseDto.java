package com.sat.quiz.dto.responseDto;

import com.sat.quiz.entity.Question;
import com.sat.quiz.entity.Variant;
import lombok.Data;

import java.util.List;

@Data
public class AnswerResponseDto {
    private Long id;
    private String answerText;
    private Boolean status;
    private Boolean isTrue;
    private VariantResponseDto variant;
   // private QuestionResponseDto question;
    //private List<String> textQuestionContext;
    

}
