package com.sat.quiz.service;

import com.sat.quiz.dto.responseDto.QuestionResponseDto;
import com.sat.quiz.dto.responseDto.result.UsersAnswersReportResponseDto;
import com.sat.quiz.entity.UsersAnswers;

import java.util.List;


public interface ReportService {
   // UerAnswerReportResponseDto addUerAnswerReport(UerAnswerReportRequestDto requestDto);

    List<UsersAnswersReportResponseDto> getUerAnswerReports();

    UsersAnswersReportResponseDto getUerAnswerReport(Long id);

    UsersAnswers getUerAnswerReportSelf(Long id);
   // UerAnswerReportResponseDto updateUerAnswerReport(Long id, UerAnswerReportRequestDto requestDto);

    UsersAnswersReportResponseDto getUserAnswers(Long quizId, Long moduleId, int orderNumber,String promoCode);

    Boolean deleteUerAnswerReport(Long id);
}
