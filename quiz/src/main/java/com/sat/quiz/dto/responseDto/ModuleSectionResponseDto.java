package com.sat.quiz.dto.responseDto;

import lombok.Data;

@Data
public class ModuleSectionResponseDto {
    private Long id;
    private String name;
   // private SectionResponseDto section;

    private int duration;

    private int numberOfQuestion;

}
