package com.sat.quiz.service;

import com.sat.quiz.dto.requestDto.TextQuestionRequestDto;
import com.sat.quiz.dto.responseDto.TextQuestionResponseDto;
import com.sat.quiz.entity.TextQuestion;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TextQuestionService {
    TextQuestionResponseDto addTextQuestion(TextQuestionRequestDto requestDto);

    List<TextQuestionResponseDto> getTextQuestions();

    TextQuestion getTextQuestionSelf(Long id);

    TextQuestionResponseDto getTextQuestion(Long id);

    TextQuestionResponseDto updateTextQuestion(Long id, TextQuestionRequestDto requestDto);

    Boolean deleteTextQuestion(Long id);

    List<TextQuestionResponseDto> getTextQuestionsWithQuizAndModule(Long quizId,Long moduleId);

  //  TextQuestionResponseDto getTextQuestionWithQuestion(Long id);

 //   List<TextQuestionResponseDto> getTextQuestionsWithQuestion();
}
