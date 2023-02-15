package com.sat.quiz.service;

import com.sat.quiz.dto.requestDto.PromoCodeDate;
import com.sat.quiz.dto.requestDto.PromoCodeRequestDto;
import com.sat.quiz.dto.responseDto.PromoCodeResponseDto;
import com.sat.quiz.entity.PromoCode;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PromoCodeService {
    PromoCodeResponseDto addPromoCode(PromoCodeRequestDto requestDto);

    List<PromoCodeResponseDto> getPromoCodes(Boolean isUsed);

    PromoCodeResponseDto getPromoCode(Long id);

    PromoCode getPromoCodeSelf(Long id);
    PromoCodeResponseDto updatePromoCode(PromoCodeDate requestDto );

    Boolean deletePromoCode(Long id);

    List<PromoCodeResponseDto> checkPromoCode(String promoCode, Long moduleId) throws Exception;

    // List<PromoCodeResponseDto> getPromoCodeWithModule(Long id);

  //  List<PromoCodeResponseDto> getPromoCodeWithText(Long id);

  //  PromoCodeResponseDto getPromoCodeWithAnswer(Long id);

 //   List<PromoCodeResponseDto> getPromoCodesWithAnswer();
}
