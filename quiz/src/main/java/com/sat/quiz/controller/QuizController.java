package com.sat.quiz.controller;

import com.sat.quiz.dto.requestDto.QuizRequestDto;
import com.sat.quiz.dto.responseDto.QuizResponseDto;
import com.sat.quiz.service.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/quizs")
public class QuizController {
    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping
    public ResponseEntity<QuizResponseDto> addQuiz(@RequestBody QuizRequestDto requestDto){
        QuizResponseDto quizResponseDto=quizService.addQuiz(requestDto);
        return ResponseEntity.ok(quizResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<QuizResponseDto>> getQuizs(){
        List<QuizResponseDto> quizResponseDtos =quizService.getQuizs();
        return ResponseEntity.ok(quizResponseDtos);
    }

    @GetMapping("{id}")
    public ResponseEntity<QuizResponseDto> getQuiz(@PathVariable("id") Long id){
        QuizResponseDto quizResponseDto= quizService.getQuiz(id);
        return ResponseEntity.ok(quizResponseDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<QuizResponseDto> updateQuiz(@PathVariable("id") Long id,
                                                                @RequestBody QuizRequestDto requestDto){
        QuizResponseDto quizResponseDto= quizService.updateQuiz(id,requestDto);
        return ResponseEntity.ok(quizResponseDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteQuiz(@PathVariable("id") Long id){
        Boolean resultQuiz=quizService.deleteQuiz(id);
        return ResponseEntity.ok(resultQuiz);
    }
}
