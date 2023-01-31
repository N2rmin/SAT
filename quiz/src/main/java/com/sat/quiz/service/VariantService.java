package com.sat.quiz.service;

import com.sat.quiz.dto.requestDto.VariantRequestDto;
import com.sat.quiz.dto.responseDto.VariantResponseDto;
import com.sat.quiz.entity.Variant;

import java.util.List;


public interface VariantService {
    VariantResponseDto addVariant(VariantRequestDto requestDto);

    List<VariantResponseDto> getVariants();

    VariantResponseDto getVariant(Long id);

    Variant getVariantSelf(Long id);
    VariantResponseDto updateVariant(Long id, VariantRequestDto requestDto);

    Boolean deleteVariant(Long id);
}
