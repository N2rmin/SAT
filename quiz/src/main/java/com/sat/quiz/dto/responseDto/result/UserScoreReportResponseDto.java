package com.sat.quiz.dto.responseDto.result;

import com.sat.quiz.dto.responseDto.ExaminerResponseDto;
import com.sat.quiz.dto.responseDto.ModuleResponseDto;
import com.sat.quiz.dto.responseDto.QuizResponseDto;
import lombok.Data;

import java.util.List;

@Data
public class UserScoreReportResponseDto {


  //  private int orderNumber;
    // private List<String> textQuestionContext;
  //  private TextQuestionResponseDto textQuestion;
    private ExaminerResponseDto examiner;
  private List<UsersAnswersCountReportResponseDto> usersAnswersCountReportResponseDtos;

    // private List<AnswerResponseDto> answers;
  //  private Boolean isOpen;

   // private Long userAnswerId;
   // private String userOpenAnswer;

   // private String name;
  //  private String lastName;


}
