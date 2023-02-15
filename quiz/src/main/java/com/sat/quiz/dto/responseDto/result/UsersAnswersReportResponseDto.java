package com.sat.quiz.dto.responseDto.result;

import com.sat.quiz.dto.responseDto.AnswerResponseDto;
import com.sat.quiz.dto.responseDto.ModuleResponseDto;
import com.sat.quiz.dto.responseDto.QuizResponseDto;
import com.sat.quiz.dto.responseDto.TextQuestionResponseDto;
import lombok.Data;

import java.util.List;

@Data
public class UsersAnswersReportResponseDto {

    private Long id;
    private String questionText;
    //  private Long textQuestionId;
    private ModuleResponseDto module;
    private int orderNumber;
    // private List<String> textQuestionContext;
    private TextQuestionResponseDto textQuestion;
    private QuizResponseDto quiz;
    private List<AnswerResponseDto> answers;
    private Boolean isOpen;

    private Long userAnswerId;
    private String userOpenAnswer;

    private String name;
    private String lastName;


}
