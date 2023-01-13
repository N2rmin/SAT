package com.sat.quiz.service;

import com.sat.quiz.dto.requestDto.QuizRequestDto;
import com.sat.quiz.dto.responseDto.QuizResponseDto;
import com.sat.quiz.entity.Quiz;

import java.util.List;


public interface QuizService {
    QuizResponseDto addQuiz(QuizRequestDto requestDto);

    List<QuizResponseDto> getQuizs();

    QuizResponseDto getQuiz(Long id);

    Quiz getQuizSelf(Long id);
    QuizResponseDto updateQuiz(Long id, QuizRequestDto requestDto);

    Boolean deleteQuiz(Long id);
}
