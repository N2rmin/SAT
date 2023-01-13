package com.sat.quiz.controller;

import com.sat.quiz.dto.requestDto.QuestionRequestDto;
import com.sat.quiz.dto.responseDto.QuestionResponseDto;
import com.sat.quiz.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/questions")
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    public ResponseEntity<QuestionResponseDto> addQuestion(@RequestBody QuestionRequestDto requestDto){
        QuestionResponseDto questionResponseDto=questionService.addQuestion(requestDto);
        return ResponseEntity.ok(questionResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<QuestionResponseDto>> getQuestions(){
        List<QuestionResponseDto> questionResponseDtos =questionService.getQuestions();
        return ResponseEntity.ok(questionResponseDtos);
    }

    @GetMapping("/withAnswers")
    public ResponseEntity<List<QuestionResponseDto>> getQuestionsWithAnswer(){
        List<QuestionResponseDto> questionResponseDtos =questionService.getQuestionsWithAnswer();
        return ResponseEntity.ok(questionResponseDtos);
    }

    @GetMapping("/getByModuleId/{moduleId}")
    public ResponseEntity<List<QuestionResponseDto>> getQuestionWithModule(@PathVariable("moduleId") Long id){
        List<QuestionResponseDto> questionResponseDtos = questionService.getQuestionWithModule(id);
        return ResponseEntity.ok(questionResponseDtos);
    }

    @GetMapping("/getWithAnswer/{id}")
    public ResponseEntity <QuestionResponseDto> getQuestionWithAnswer(@PathVariable("id") Long id){
        QuestionResponseDto questionResponseDtos = questionService.getQuestionWithAnswer(id);
        return ResponseEntity.ok(questionResponseDtos);
    }

    @GetMapping("/getByTextId/{textId}")
    public ResponseEntity<List<QuestionResponseDto>> getQuestionWithText(@PathVariable("textId") Long id){
        List<QuestionResponseDto> questionResponseDtos = questionService.getQuestionWithText(id);
        return ResponseEntity.ok(questionResponseDtos);
    }

    @GetMapping("{id}")
    public ResponseEntity<QuestionResponseDto> getQuestion(@PathVariable("id") Long id){
        QuestionResponseDto questionResponseDto= questionService.getQuestion(id);
        return ResponseEntity.ok(questionResponseDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<QuestionResponseDto> updateQuestion(@PathVariable("id") Long id,
                                                                @RequestBody QuestionRequestDto requestDto){
        QuestionResponseDto questionResponseDto= questionService.updateQuestion(id,requestDto);
        return ResponseEntity.ok(questionResponseDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteQuestion(@PathVariable("id") Long id){
        Boolean resultQuestion=questionService.deleteQuestion(id);
        return ResponseEntity.ok(resultQuestion);
    }
}
