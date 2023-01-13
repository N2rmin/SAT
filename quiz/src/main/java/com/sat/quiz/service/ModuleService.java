package com.sat.quiz.service;

import com.sat.quiz.dto.requestDto.ModuleRequestDto;
import com.sat.quiz.dto.responseDto.ModuleResponseDto;
import com.sat.quiz.entity.Module;

import java.util.List;


public interface ModuleService {
    ModuleResponseDto addModule(ModuleRequestDto requestDto);

    List<ModuleResponseDto> getModules();

    ModuleResponseDto getModule(Long id);

    Module getModuleSelf(Long id);
    ModuleResponseDto updateModule(Long id, ModuleRequestDto requestDto);

    Boolean deleteModule(Long id);
}
