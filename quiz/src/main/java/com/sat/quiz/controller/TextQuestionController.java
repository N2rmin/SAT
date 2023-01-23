package com.sat.quiz.controller;


import com.sat.quiz.dto.requestDto.TextQuestionRequestDto;
import com.sat.quiz.dto.responseDto.TextQuestionResponseDto;
import com.sat.quiz.service.TextQuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/textQuestions")
public class TextQuestionController {
    private final TextQuestionService textQuestionService;

    public TextQuestionController(TextQuestionService textQuestionService) {
        this.textQuestionService = textQuestionService;
    }

    @PostMapping
    public ResponseEntity<TextQuestionResponseDto> addTextQuestion(@RequestBody TextQuestionRequestDto requestDto){
        TextQuestionResponseDto textQuestionResponseDto=textQuestionService.addTextQuestion(requestDto);
        return ResponseEntity.ok(textQuestionResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<TextQuestionResponseDto>> getTextQuestions(){
        List<TextQuestionResponseDto> textQuestionResponseDtos =textQuestionService.getTextQuestions();
        return ResponseEntity.ok(textQuestionResponseDtos);
    }
//    @GetMapping("/withQuestion")
//    public ResponseEntity<List<TextQuestionResponseDto>> getTextQuestionsWithQuestion(){
//        List<TextQuestionResponseDto> textQuestionResponseDtos =textQuestionService.getTextQuestionsWithQuestion();
//        return ResponseEntity.ok(textQuestionResponseDtos);
//    }

    @GetMapping("{id}")
    public ResponseEntity<TextQuestionResponseDto> getTextQuestion(@PathVariable("id") Long id){
        TextQuestionResponseDto textQuestionResponseDto= textQuestionService.getTextQuestion(id);
        return ResponseEntity.ok(textQuestionResponseDto);
    }
//    @GetMapping("/withQuestion/{id}")
//    public ResponseEntity<TextQuestionResponseDto> getTextQuestionWithQuestion(@PathVariable("id") Long id){
//        TextQuestionResponseDto textQuestionResponseDto= textQuestionService.getTextQuestionWithQuestion(id);
//        return ResponseEntity.ok(textQuestionResponseDto);
//    }

    @PutMapping("{id}")
    public ResponseEntity<TextQuestionResponseDto> updateTextQuestion(@PathVariable("id") Long id,
                                                                @RequestBody TextQuestionRequestDto requestDto){
        TextQuestionResponseDto textQuestionResponseDto= textQuestionService.updateTextQuestion(id,requestDto);
        return ResponseEntity.ok(textQuestionResponseDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteTextQuestion(@PathVariable("id") Long id){
        Boolean resultTextQuestion=textQuestionService.deleteTextQuestion(id);
        return ResponseEntity.ok(resultTextQuestion);
    }



}
