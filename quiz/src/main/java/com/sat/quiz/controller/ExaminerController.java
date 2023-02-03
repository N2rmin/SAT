package com.sat.quiz.controller;

import com.sat.quiz.dto.requestDto.ExaminerRequestDto;
import com.sat.quiz.dto.responseDto.ExaminerResponseDto;
import com.sat.quiz.service.ExaminerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/examiners")
public class ExaminerController {
    private final ExaminerService examinerService;

    public ExaminerController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @PostMapping
    public ResponseEntity<ExaminerResponseDto> addExaminer(@Valid @RequestBody ExaminerRequestDto requestDto) throws Exception {
        ExaminerResponseDto examinerResponseDto=examinerService.addExaminer(requestDto);
        return ResponseEntity.ok(examinerResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<ExaminerResponseDto>> getExaminers(){
        List<ExaminerResponseDto> examinerResponseDtos =examinerService.getExaminers();
        return ResponseEntity.ok(examinerResponseDtos);
    }

  /*  @GetMapping("/withAnswers")
    public ResponseEntity<List<ExaminerResponseDto>> getExaminersWithAnswer(){
        List<ExaminerResponseDto> examinerResponseDtos =examinerService.getExaminersWithAnswer();
        return ResponseEntity.ok(examinerResponseDtos);
    }

    @GetMapping("/getByModuleId/{moduleId}")
    public ResponseEntity<List<ExaminerResponseDto>> getExaminerWithModule(@PathVariable("moduleId") Long id){
        List<ExaminerResponseDto> examinerResponseDtos = examinerService.getExaminerWithModule(id);
        return ResponseEntity.ok(examinerResponseDtos);
    }

    @GetMapping("/getWithAnswer/{id}")
    public ResponseEntity <ExaminerResponseDto> getExaminerWithAnswer(@PathVariable("id") Long id){
        ExaminerResponseDto examinerResponseDtos = examinerService.getExaminerWithAnswer(id);
        return ResponseEntity.ok(examinerResponseDtos);
    }

    @GetMapping("/getByTextId/{textId}")
    public ResponseEntity<List<ExaminerResponseDto>> getExaminerWithText(@PathVariable("textId") Long id){
        List<ExaminerResponseDto> examinerResponseDtos = examinerService.getExaminerWithText(id);
        return ResponseEntity.ok(examinerResponseDtos);
    }*/

    @GetMapping("{id}")
    public ResponseEntity<ExaminerResponseDto> getExaminer(@PathVariable("id") Long id){
        ExaminerResponseDto examinerResponseDto= examinerService.getExaminer(id);
        return ResponseEntity.ok(examinerResponseDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<ExaminerResponseDto> updateExaminer(@PathVariable("id") Long id,
                                                                @RequestBody ExaminerRequestDto requestDto){
        ExaminerResponseDto examinerResponseDto= examinerService.updateExaminer(id,requestDto);
        return ResponseEntity.ok(examinerResponseDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteExaminer(@PathVariable("id") Long id){
        Boolean examinerExaminer=examinerService.deleteExaminer(id);
        return ResponseEntity.ok(examinerExaminer);
    }
}
