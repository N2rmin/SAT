package com.sat.quiz.dto.responseDto;

import lombok.Data;

import java.util.List;

@Data
public class SectionResponseDto {
    private Long id;
    private String name;
    private boolean status;
    private List<ModuleResponseDto> ModuleResponseDto;

}
