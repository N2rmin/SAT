package com.sat.quiz.dto.responseDto;

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
    private List<String> moduleNames;
    private List<String> textQuestion;
    //
    // private List<String> textQuestionContext;
    private List<String> quizNames;
    private Map<Long,String> answerText;


    public QuestionResponseDto(Long id, String questionText) {
        this.id=id;
        this.questionText=questionText;
    }
}
