package com.sat.quiz.service;

import com.sat.quiz.dto.requestDto.QuestionRequestDto;
import com.sat.quiz.dto.responseDto.ExamResponseDto;
import com.sat.quiz.dto.responseDto.QuestionResponseDto;
import com.sat.quiz.dto.responseDto.TextQuestionResponseDto;
import com.sat.quiz.entity.Question;

import java.util.List;


public interface QuestionService {
    QuestionResponseDto addQuestion(QuestionRequestDto requestDto);

    List<QuestionResponseDto> getQuestions();

    List<QuestionResponseDto> getQuizAndModuleQuestions(Long quizId, Long moduleId);

    QuestionResponseDto getQuestion(Long id);

    Question getQuestionSelf(Long id);
    QuestionResponseDto updateQuestion(Long id, QuestionRequestDto requestDto);

    Boolean deleteQuestion(Long id);

    List<TextQuestionResponseDto> findAll();

    QuestionResponseDto getQuestionForExam(Long quizId, Long moduleId, int orderNumber);

    List<Object> getQuestionOrderNumbers(Long quizId, Long moduleId);

    QuestionResponseDto getQuestionWithAnswer(Long quizId, Long moduleId, int orderNumber);


    //  ExamResponseDto getQuizAndModuleQuestions(Long moduleId);

   // List<QuestionResponseDto> getQuestionWithModule(Long id);

  //  List<QuestionResponseDto> getQuestionWithText(Long id);

 //   QuestionResponseDto getQuestionWithAnswer(Long id);

  //  List<QuestionResponseDto> getQuestionsWithAnswer();
}
