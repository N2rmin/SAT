package com.sat.quiz.service;

import com.sat.quiz.dto.requestDto.ResultRequestDto;
import com.sat.quiz.dto.responseDto.ResultResponseDto;
import com.sat.quiz.entity.Result;

import java.util.List;


public interface ResultService {
    ResultResponseDto addResult(ResultRequestDto requestDto);

    List<ResultResponseDto> getResults();

    ResultResponseDto getResult(Long id);

    Result getResultSelf(Long id);
    ResultResponseDto updateResult(Long id, ResultRequestDto requestDto);

    Boolean deleteResult(Long id);

    List<ResultResponseDto> getResultWithModule(Long id);

    List<ResultResponseDto> getResultWithText(Long id);

    ResultResponseDto getResultWithAnswer(Long id);

    List<ResultResponseDto> getResultsWithAnswer();
}
