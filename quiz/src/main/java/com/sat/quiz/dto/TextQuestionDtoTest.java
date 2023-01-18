package com.sat.quiz.dto;

import lombok.Data;

import java.util.List;

@Data
public class TextQuestionDtoTest {


    private Long id;


    private String questionText;
    private boolean status;

    private List<QuestionDtoTest> questions;
}
