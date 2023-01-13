package com.sat.quiz.dto.responseDto;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class QuestionResponseDto {
    private Long id;
    private String questionText;
  //  private Long textQuestionId;
    private List<String> moduleNames;
    private List<String> textQuestion;
    //
    // private List<String> textQuestionContext;
    private List<String> quizNames;
    private Map<Long,String> answerText;

}
