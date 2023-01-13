package com.sat.quiz.dto.responseDto;

import com.sat.quiz.entity.Question;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ResultResponseDto {
    private Long id;
    private String username;


    private int score;
    private Boolean status;
    //  private Long textQuestionId;
    //private List<String> moduleNames;
   // private List<String> textQuestion;
    //
    // private List<String> textQuestionContext;
    private List<String> quizNames;
    //private Map<Long,String> answerText;
}
