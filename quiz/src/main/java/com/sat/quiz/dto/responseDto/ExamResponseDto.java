package com.sat.quiz.dto.responseDto;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ExamResponseDto {
    private List<TextQuestionResponseDto> textQuestionResponseDtos;

    private List<QuestionResponseDto> questionResponseDtos;

    //private Map<Long,String> answerText;
}
