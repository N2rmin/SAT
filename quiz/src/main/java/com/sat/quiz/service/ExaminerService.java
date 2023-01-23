package com.sat.quiz.service;

import com.sat.quiz.dto.requestDto.ExaminerRequestDto;
import com.sat.quiz.dto.responseDto.ExaminerResponseDto;
import com.sat.quiz.entity.Examiner;

import java.util.List;


public interface ExaminerService {
    ExaminerResponseDto addExaminer(ExaminerRequestDto requestDto);

    List<ExaminerResponseDto> getExaminers();

    ExaminerResponseDto getExaminer(Long id);

    Examiner getExaminerSelf(Long id);
    ExaminerResponseDto updateExaminer(Long id, ExaminerRequestDto requestDto);

    Boolean deleteExaminer(Long id);

   // List<ExaminerResponseDto> getExaminerWithModule(Long id);

  //  List<ExaminerResponseDto> getExaminerWithText(Long id);

  //  ExaminerResponseDto getExaminerWithAnswer(Long id);

 //   List<ExaminerResponseDto> getExaminersWithAnswer();
}
