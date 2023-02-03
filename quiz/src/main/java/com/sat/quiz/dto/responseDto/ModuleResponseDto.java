package com.sat.quiz.dto.responseDto;

import lombok.Data;

import java.util.List;

@Data
public class ModuleResponseDto {
    private Long id;
    private String name;
    private SectionResponseDto section;

    private int duration;
}
