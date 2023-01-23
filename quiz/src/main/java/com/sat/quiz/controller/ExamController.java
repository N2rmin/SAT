package com.sat.quiz.controller;

import com.sat.quiz.dto.QuestionDtoTest;
import com.sat.quiz.dto.TextQuestionDtoTest;
import com.sat.quiz.dto.requestDto.QuestionRequestDto;
import com.sat.quiz.dto.responseDto.ExamResponseDto;
import com.sat.quiz.dto.responseDto.QuestionResponseDto;
import com.sat.quiz.repository.QuestionRepository;
import com.sat.quiz.repository.TextQuestionRepository;
import com.sat.quiz.service.QuestionService;
import com.sat.quiz.service.impl.ExamServiceImpl;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/exams")
@RequiredArgsConstructor
public class ExamController {
    private final QuestionService questionService;

    private final ModelMapper modelMapper;
    private final ExamServiceImpl examService;

    private final TextQuestionRepository textQuestionRepository;
    private final QuestionRepository questionRepository;



//    @PostMapping
//    public ResponseEntity<QuestionResponseDto> addQuestion(@RequestBody QuestionRequestDto requestDto){
//        QuestionResponseDto questionResponseDto=questionService.addQuestion(requestDto);
//        return ResponseEntity.ok(questionResponseDto);
//    }

    @GetMapping("/{quizId}/{moduleId}")
    public ResponseEntity<ExamResponseDto> getExam(@PathVariable("quizId") Long quizId,
            @PathVariable("moduleId") Long moduleId){
        ExamResponseDto examResponseDto =examService.exam(quizId,moduleId);
        return ResponseEntity.ok(examResponseDto);
    }

//    @GetMapping("test")
//    public List<QuestionDtoTest> getQuestionsTest(){
//        List<QuestionDtoTest> list = new ArrayList<>();
//        //System.out.println(questionRepository.findAll());
//        questionRepository.findAll().stream().forEach(obj->{
//            list.add(modelMapper.map(obj,QuestionDtoTest.class));
//        });
//        return list;
//    }
//
//    @GetMapping("testText")
//    public List<TextQuestionDtoTest> getTextQuestionsTest(){
//        List<TextQuestionDtoTest> list = new ArrayList<>();
//
//        textQuestionRepository.findAll().stream().forEach(obj->{
//            list.add(modelMapper.map(obj,TextQuestionDtoTest.class));
//        });
//        return list;
//    }
//    @GetMapping("/withAnswers")
//    public ResponseEntity<List<QuestionResponseDto>> getQuestionsWithAnswer(){
//        List<QuestionResponseDto> questionResponseDtos =questionService.getQuestionsWithAnswer();
//        return ResponseEntity.ok(questionResponseDtos);
//    }
//
//    @GetMapping("/getByModuleId/{moduleId}")
//    public ResponseEntity<List<QuestionResponseDto>> getQuestionWithModule(@PathVariable("moduleId") Long id){
//        List<QuestionResponseDto> questionResponseDtos = questionService.getQuestionWithModule(id);
//        return ResponseEntity.ok(questionResponseDtos);
//    }
//
//
//    @GetMapping("/questionToExamResponseDto/{moduleId}")
//    public ResponseEntity<ExamResponseDto>questionToExamResponseDto(@PathVariable("moduleId") Long id){
//        questionService.questionToExamResponseDto(id);
//        return ResponseEntity.ok( questionService.questionToExamResponseDto(id));
//    }
//
//    @GetMapping("/getWithAnswer/{id}")
//    public ResponseEntity <QuestionResponseDto> getQuestionWithAnswer(@PathVariable("id") Long id){
//        QuestionResponseDto questionResponseDtos = questionService.getQuestionWithAnswer(id);
//        return ResponseEntity.ok(questionResponseDtos);
//    }
//
//    @GetMapping("/getByTextId/{textId}")
//    public ResponseEntity<List<QuestionResponseDto>> getQuestionWithText(@PathVariable("textId") Long id){
//        List<QuestionResponseDto> questionResponseDtos = questionService.getQuestionWithText(id);
//        return ResponseEntity.ok(questionResponseDtos);
//    }

//    @GetMapping("{id}")
//    public ResponseEntity<QuestionResponseDto> getQuestion(@PathVariable("id") Long id){
//        QuestionResponseDto questionResponseDto= questionService.getQuestion(id);
//        return ResponseEntity.ok(questionResponseDto);
//    }
//
//    @PutMapping("{id}")
//    public ResponseEntity<QuestionResponseDto> updateQuestion(@PathVariable("id") Long id,
//                                                                @RequestBody QuestionRequestDto requestDto){
//        QuestionResponseDto questionResponseDto= questionService.updateQuestion(id,requestDto);
//        return ResponseEntity.ok(questionResponseDto);
//    }
//
//    @DeleteMapping("{id}")
//    public ResponseEntity<Boolean> deleteQuestion(@PathVariable("id") Long id){
//        Boolean resultQuestion=questionService.deleteQuestion(id);
//        return ResponseEntity.ok(resultQuestion);
//    }
}
