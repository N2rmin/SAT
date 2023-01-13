package com.sat.quiz.controller;

import com.sat.quiz.dto.requestDto.ResultRequestDto;
import com.sat.quiz.dto.responseDto.ResultResponseDto;
import com.sat.quiz.service.ResultService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/results")
public class ResultController {
    private final ResultService resultService;

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @PostMapping
    public ResponseEntity<ResultResponseDto> addResult(@Valid @RequestBody ResultRequestDto requestDto){
        ResultResponseDto resultResponseDto=resultService.addResult(requestDto);
        return ResponseEntity.ok(resultResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<ResultResponseDto>> getResults(){
        List<ResultResponseDto> resultResponseDtos =resultService.getResults();
        return ResponseEntity.ok(resultResponseDtos);
    }

  /*  @GetMapping("/withAnswers")
    public ResponseEntity<List<ResultResponseDto>> getResultsWithAnswer(){
        List<ResultResponseDto> resultResponseDtos =resultService.getResultsWithAnswer();
        return ResponseEntity.ok(resultResponseDtos);
    }

    @GetMapping("/getByModuleId/{moduleId}")
    public ResponseEntity<List<ResultResponseDto>> getResultWithModule(@PathVariable("moduleId") Long id){
        List<ResultResponseDto> resultResponseDtos = resultService.getResultWithModule(id);
        return ResponseEntity.ok(resultResponseDtos);
    }

    @GetMapping("/getWithAnswer/{id}")
    public ResponseEntity <ResultResponseDto> getResultWithAnswer(@PathVariable("id") Long id){
        ResultResponseDto resultResponseDtos = resultService.getResultWithAnswer(id);
        return ResponseEntity.ok(resultResponseDtos);
    }

    @GetMapping("/getByTextId/{textId}")
    public ResponseEntity<List<ResultResponseDto>> getResultWithText(@PathVariable("textId") Long id){
        List<ResultResponseDto> resultResponseDtos = resultService.getResultWithText(id);
        return ResponseEntity.ok(resultResponseDtos);
    }*/

    @GetMapping("{id}")
    public ResponseEntity<ResultResponseDto> getResult(@PathVariable("id") Long id){
        ResultResponseDto resultResponseDto= resultService.getResult(id);
        return ResponseEntity.ok(resultResponseDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<ResultResponseDto> updateResult(@PathVariable("id") Long id,
                                                                @RequestBody ResultRequestDto requestDto){
        ResultResponseDto resultResponseDto= resultService.updateResult(id,requestDto);
        return ResponseEntity.ok(resultResponseDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteResult(@PathVariable("id") Long id){
        Boolean resultResult=resultService.deleteResult(id);
        return ResponseEntity.ok(resultResult);
    }
}
