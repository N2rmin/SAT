package com.sat.quiz.controller;

import com.sat.quiz.dto.requestDto.AnswerRequestDto;
import com.sat.quiz.dto.responseDto.AnswerResponseDto;
import com.sat.quiz.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/answers")
@RequiredArgsConstructor
public class AnswerController {
    private final AnswerService answerService;


    @PostMapping
    public ResponseEntity<AnswerResponseDto> addAnswer(@RequestBody AnswerRequestDto requestDto){
        AnswerResponseDto answerResponseDto=answerService.addAnswer(requestDto);
        return ResponseEntity.ok(answerResponseDto);
    }


    @GetMapping
    public ResponseEntity<List<AnswerResponseDto>> getAnswers(){
        List<AnswerResponseDto> answerResponseDtos =answerService.getAnswers();
        return ResponseEntity.ok(answerResponseDtos);
    }

    @GetMapping("{id}")
    public ResponseEntity<AnswerResponseDto> getAnswer(@PathVariable("id") Long id){
        AnswerResponseDto answerResponseDto= answerService.getAnswer(id);
        return ResponseEntity.ok(answerResponseDto);
    }

//    @GetMapping("getByQuestionId/{questionId}")
//    public ResponseEntity<List<AnswerResponseDto>> getAnswersWithQuestion(@PathVariable("questionId") Long id){
//        return ResponseEntity.ok(answerService.getAnswersWithQuestion(id));
//    }

    @PutMapping("{id}")
    public ResponseEntity<AnswerResponseDto> updateAnswer(@PathVariable("id") Long id,
                                                                @RequestBody AnswerRequestDto requestDto){
        AnswerResponseDto answerResponseDto= answerService.updateAnswer(id,requestDto);
        return ResponseEntity.ok(answerResponseDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteAnswer(@PathVariable("id") Long id){
        Boolean resultAnswer=answerService.deleteAnswer(id);
        return ResponseEntity.ok(resultAnswer);
    }
}
