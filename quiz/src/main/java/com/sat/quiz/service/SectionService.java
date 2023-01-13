package com.sat.quiz.service;

import com.sat.quiz.dto.requestDto.SectionRequestDto;
import com.sat.quiz.dto.responseDto.SectionResponseDto;
import com.sat.quiz.entity.Section;
import org.springframework.stereotype.Service;

import java.util.List;


public interface SectionService {
    SectionResponseDto addSection(SectionRequestDto requestDto);

    List<SectionResponseDto> getSections();

    SectionResponseDto getSection(Long id);

    Section getSectionSelf(Long id);
    SectionResponseDto updateSection(Long id, SectionRequestDto requestDto);

    Boolean deleteSection(Long id);
}
