package com.sat.quiz.dto.responseDto.result;

import com.sat.quiz.dto.responseDto.AnswerResponseDto;
import com.sat.quiz.dto.responseDto.ExaminerResponseDto;
import com.sat.quiz.dto.responseDto.ModuleResponseDto;
import com.sat.quiz.dto.responseDto.QuizResponseDto;
import com.sat.quiz.dto.responseDto.TextQuestionResponseDto;
import lombok.Data;

import java.util.List;

@Data
public class UsersAnswersCountReportResponseDto {

    private Long id;
   // private String questionText;
    //  private Long textQuestionId;
   private int score;
  //  private int orderNumber;
    // private List<String> textQuestionContext;
  //  private TextQuestionResponseDto textQuestion;
    private ModuleResponseDto module;

    // private List<AnswerResponseDto> answers;
  //  private Boolean isOpen;

   // private Long userAnswerId;
   // private String userOpenAnswer;

   // private String name;
  //  private String lastName;


}
