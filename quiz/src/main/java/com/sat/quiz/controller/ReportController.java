package com.sat.quiz.controller;

import com.sat.quiz.dto.requestDto.VariantRequestDto;
import com.sat.quiz.dto.responseDto.QuestionResponseDto;
import com.sat.quiz.dto.responseDto.VariantResponseDto;
import com.sat.quiz.dto.responseDto.result.UsersAnswersReportResponseDto;
import com.sat.quiz.service.ReportService;
import com.sat.quiz.service.VariantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/report")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;



    @Transactional
    @GetMapping("userAnswer/{quizId}/{moduleId}/{orderNumber}/{promoCode}")
    public ResponseEntity<UsersAnswersReportResponseDto> getQuestionForExam(
            @PathVariable("quizId") Long quizId,
            @PathVariable("moduleId") Long moduleId,
                                                                            @PathVariable("orderNumber") int orderNumber,

                                                                            @PathVariable("promoCode") String promoCode){
        UsersAnswersReportResponseDto usersAnswersReportResponseDto =reportService.getUserAnswers(quizId,moduleId,orderNumber,promoCode);
        return ResponseEntity.ok(usersAnswersReportResponseDto);
    }

//    private final VariantService variantService;
//
//    public UserAnswerController(VariantService variantService) {
//        this.variantService = variantService;
//    }
//
//    @PostMapping
//    public ResponseEntity<VariantResponseDto> addVariant(@RequestBody VariantRequestDto requestDto){
//        VariantResponseDto variantResponseDto=variantService.addVariant(requestDto);
//        return ResponseEntity.ok(variantResponseDto);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<VariantResponseDto>> getVariants(){
//        List<VariantResponseDto> variantResponseDtos =variantService.getVariants();
//        return ResponseEntity.ok(variantResponseDtos);
//    }
//
//    @GetMapping("{id}")
//    public ResponseEntity<VariantResponseDto> getVariant(@PathVariable("id") Long id){
//        VariantResponseDto variantResponseDto= variantService.getVariant(id);
//        return ResponseEntity.ok(variantResponseDto);
//    }
//
//    @PutMapping("{id}")
//    public ResponseEntity<VariantResponseDto> updateVariant(@PathVariable("id") Long id,
//                                                                @RequestBody VariantRequestDto requestDto){
//        VariantResponseDto variantResponseDto= variantService.updateVariant(id,requestDto);
//        return ResponseEntity.ok(variantResponseDto);
//    }
//
//    @DeleteMapping("{id}")
//    public ResponseEntity<Boolean> deleteVariant(@PathVariable("id") Long id){
//        Boolean resultVariant=variantService.deleteVariant(id);
//        return ResponseEntity.ok(resultVariant);
//    }
}
