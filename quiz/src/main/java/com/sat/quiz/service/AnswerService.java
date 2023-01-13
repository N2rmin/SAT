package com.sat.quiz.service;

import com.sat.quiz.dto.requestDto.AnswerRequestDto;
import com.sat.quiz.dto.responseDto.AnswerResponseDto;
import com.sat.quiz.entity.Answer;

import java.util.List;


public interface AnswerService {
    AnswerResponseDto addAnswer(AnswerRequestDto requestDto);

    List<AnswerResponseDto> getAnswers();

    AnswerResponseDto getAnswer(Long id);

    Answer getAnswerSelf(Long id);
    AnswerResponseDto updateAnswer(Long id, AnswerRequestDto requestDto);

    Boolean deleteAnswer(Long id);

    List<AnswerResponseDto> getAnswersWithQuestion(Long id);
}
