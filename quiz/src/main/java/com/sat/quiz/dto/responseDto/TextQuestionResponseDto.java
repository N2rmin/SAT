package com.sat.quiz.dto.responseDto;

import com.sat.quiz.entity.Question;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class TextQuestionResponseDto {
    private Long id;
    private String textContent;
    private boolean status;

    private List<QuestionResponseDto> questions;


   // private Map<Object,Object> questionAnswer;

}
