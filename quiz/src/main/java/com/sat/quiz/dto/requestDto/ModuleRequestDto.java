package com.sat.quiz.dto.requestDto;

import lombok.Data;

@Data
public class ModuleRequestDto {
    private String name;
    private boolean status;
    private Long sectionId;
}
