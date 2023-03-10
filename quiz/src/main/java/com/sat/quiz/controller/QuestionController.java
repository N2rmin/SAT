package com.sat.quiz.controller;

import com.sat.quiz.dto.QuestionDtoTest;
import com.sat.quiz.dto.TextQuestionDtoTest;
import com.sat.quiz.dto.requestDto.QuestionRequestDto;
import com.sat.quiz.dto.responseDto.ExamResponseDto;
import com.sat.quiz.dto.responseDto.QuestionResponseDto;
import com.sat.quiz.dto.responseDto.TextQuestionResponseDto;
import com.sat.quiz.entity.TextQuestion;
import com.sat.quiz.repository.QuestionRepository;
import com.sat.quiz.repository.TextQuestionRepository;
import com.sat.quiz.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/questions")
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    private final ModelMapper modelMapper;

    private final TextQuestionRepository textQuestionRepository;
private final QuestionRepository questionRepository;



    @Transactional
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

    @GetMapping("test")
    public List<QuestionDtoTest> getQuestionsTest(){
        List<QuestionDtoTest> list = new ArrayList<>();
        //System.out.println(questionRepository.findAll());
        questionRepository.findAllByTextQuestionIdNotNull().stream().forEach(obj->{
            list.add(modelMapper.map(obj,QuestionDtoTest.class));
        });
        return list;
    }

//    @GetMapping("testTextwith/{quizId}/{moduleId}")
//    public List<TextQuestionDtoTest> getwithQuestionsTest(@PathVariable("quizId") Long quizId,@PathVariable("moduleId") Long moduleId){
//        List<TextQuestionDtoTest> list = new ArrayList<>();
//
//        textQuestionRepository.findAllByQuestions_QuizIdAndQuestions_ModuleId(quizId,moduleId).stream().forEach(obj->{
//            list.add(modelMapper.map(obj,TextQuestionDtoTest.class));
//        });
//        return list;
//    }

    @Transactional
    @GetMapping("questionForExam/{quizId}/{moduleId}/{orderNumber}")
    public ResponseEntity<QuestionResponseDto> getQuestionForExam(@PathVariable("quizId") Long quizId,@PathVariable("moduleId") Long moduleId,
                                                    @PathVariable("orderNumber") int orderNumber
                                                                 ){
      QuestionResponseDto questionResponseDto =questionService.getQuestionForExam(quizId,moduleId,orderNumber);
        return ResponseEntity.ok(questionResponseDto);
    }

    @Transactional
    @GetMapping("questionWithAnswer/{quizId}/{moduleId}/{orderNumber}")
    public ResponseEntity<QuestionResponseDto> getQuestionWithAnswer(@PathVariable("quizId") Long quizId,@PathVariable("moduleId") Long moduleId,
                                                                  @PathVariable("orderNumber") int orderNumber
                                                                  ){
        QuestionResponseDto questionResponseDto =questionService.getQuestionWithAnswer(quizId,moduleId,orderNumber);
        return ResponseEntity.ok(questionResponseDto);
    }

    @Transactional
    @GetMapping("orderNumbers/{quizId}/{moduleId}")
    public ResponseEntity<List<Object>> getQuestionOrderNumbers(@PathVariable("quizId") Long quizId,@PathVariable("moduleId") Long moduleId){
        List<Object> orderNumbers =questionService.getQuestionOrderNumbers(quizId,moduleId);
        return ResponseEntity.ok(orderNumbers);
    }

    @GetMapping("testText")
    public List<TextQuestionDtoTest> getTextQuestionsTest(){
        List<TextQuestionDtoTest> list = new ArrayList<>();

        textQuestionRepository.findAll().stream().forEach(obj->{
            list.add(modelMapper.map(obj,TextQuestionDtoTest.class));
        });
        return list;
    }

    @GetMapping("testText1")
    public List<TextQuestionResponseDto> getTextQuestionsTest1(){


        return questionService.findAll();
    }




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

    @GetMapping("{id}")
    public ResponseEntity<QuestionResponseDto> getQuestion(@PathVariable("id") Long id){
        QuestionResponseDto questionResponseDto= questionService.getQuestion(id);
        return ResponseEntity.ok(questionResponseDto);
    }

    @Transactional
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
