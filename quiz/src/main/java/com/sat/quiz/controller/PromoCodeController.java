package com.sat.quiz.controller;

import com.sat.quiz.dto.requestDto.PromoCodeRequestDto;
import com.sat.quiz.dto.responseDto.PromoCodeResponseDto;
import com.sat.quiz.service.PromoCodeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/promoCodes")
public class PromoCodeController {
    private final PromoCodeService promoCodeService;

    public PromoCodeController(PromoCodeService promoCodeService) {
        this.promoCodeService = promoCodeService;
    }

    @PostMapping
    public ResponseEntity<PromoCodeResponseDto> addPromoCode(@Valid @RequestBody PromoCodeRequestDto requestDto){
        PromoCodeResponseDto promoCodeResponseDto=promoCodeService.addPromoCode(requestDto);
        return ResponseEntity.ok(promoCodeResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<PromoCodeResponseDto>> getPromoCodes(){
        List<PromoCodeResponseDto> promoCodeResponseDtos =promoCodeService.getPromoCodes();
        return ResponseEntity.ok(promoCodeResponseDtos);
    }

  /*  @GetMapping("/withAnswers")
    public ResponseEntity<List<PromoCodeResponseDto>> getPromoCodesWithAnswer(){
        List<PromoCodeResponseDto> promoCodeResponseDtos =promoCodeService.getPromoCodesWithAnswer();
        return ResponseEntity.ok(promoCodeResponseDtos);
    }

    @GetMapping("/getByModuleId/{moduleId}")
    public ResponseEntity<List<PromoCodeResponseDto>> getPromoCodeWithModule(@PathVariable("moduleId") Long id){
        List<PromoCodeResponseDto> promoCodeResponseDtos = promoCodeService.getPromoCodeWithModule(id);
        return ResponseEntity.ok(promoCodeResponseDtos);
    }

    @GetMapping("/getWithAnswer/{id}")
    public ResponseEntity <PromoCodeResponseDto> getPromoCodeWithAnswer(@PathVariable("id") Long id){
        PromoCodeResponseDto promoCodeResponseDtos = promoCodeService.getPromoCodeWithAnswer(id);
        return ResponseEntity.ok(promoCodeResponseDtos);
    }

    @GetMapping("/getByTextId/{textId}")
    public ResponseEntity<List<PromoCodeResponseDto>> getPromoCodeWithText(@PathVariable("textId") Long id){
        List<PromoCodeResponseDto> promoCodeResponseDtos = promoCodeService.getPromoCodeWithText(id);
        return ResponseEntity.ok(promoCodeResponseDtos);
    }*/

    @GetMapping("{id}")
    public ResponseEntity<PromoCodeResponseDto> getPromoCode(@PathVariable("id") Long id){
        PromoCodeResponseDto promoCodeResponseDto= promoCodeService.getPromoCode(id);
        return ResponseEntity.ok(promoCodeResponseDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<PromoCodeResponseDto> updatePromoCode(@PathVariable("id") Long id,
                                                                @RequestBody PromoCodeRequestDto requestDto){
        PromoCodeResponseDto promoCodeResponseDto= promoCodeService.updatePromoCode(id,requestDto);
        return ResponseEntity.ok(promoCodeResponseDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deletePromoCode(@PathVariable("id") Long id){
        Boolean promoCodePromoCode=promoCodeService.deletePromoCode(id);
        return ResponseEntity.ok(promoCodePromoCode);
    }
}
