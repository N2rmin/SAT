package com.sat.quiz.service.impl;

import com.sat.quiz.dto.mapper;
import com.sat.quiz.dto.requestDto.QuestionRequestDto;
import com.sat.quiz.dto.responseDto.QuestionResponseDto;
import com.sat.quiz.entity.*;
import com.sat.quiz.entity.Module;
import com.sat.quiz.repository.QuestionRepository;
import com.sat.quiz.service.ModuleService;
import com.sat.quiz.service.QuestionService;
import com.sat.quiz.service.QuizService;
import com.sat.quiz.service.TextQuestionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private  final QuestionRepository questionRepository;
    private final ModuleService moduleService;

    private final QuizService quizService;

    private final TextQuestionService textQuestionService;

    private final ModelMapper modelMapper;

    @Override
    public QuestionResponseDto addQuestion(QuestionRequestDto requestDto) {
        Question question= new Question();
        if (requestDto.getModuleId()==null){
            throw  new IllegalArgumentException("question at least one module");
        }
        Module module= moduleService.getModuleSelf(requestDto.getModuleId());
        question.setModule(module);
        if (requestDto.getQuizId()==null){
            throw  new IllegalArgumentException("question at least one quiz");
        }
        Quiz quiz= quizService.getQuizSelf(requestDto.getQuizId());
        question.setQuiz(quiz);

        if (requestDto.getTextQuestionId()==null ){
            question.setTextQuestion(null);

        }else{
            TextQuestion textQuestion=textQuestionService.getTextQuestionSelf(requestDto.getTextQuestionId());
            question.setTextQuestion(textQuestion);}

        //TextQuestion textQuestion= textQuestionService.getTextQuestionSelf(requestDto.getTextQuestionId());
       // question.setTextQuestionId(requestDto.getTextQuestionId());
        question.setQuestionText(requestDto.getQuestionText());
        question.setStatus(requestDto.isStatus());
        return mapper.questionToQuestionResponseDto(questionRepository.save(question) );

    }

    @Override
    public List<QuestionResponseDto> getQuestions() {
        List<Question> questions=StreamSupport
                .stream(questionRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
        return mapper.questionToQuestionResponseDtos(questions);


    }

    @Override
    public List<QuestionResponseDto> getQuestionsWithAnswer() {
        List<Question> questions=StreamSupport
                .stream(questionRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
        return mapper.questionWithAnswerResponseDtos(questions);
    }

    @Override
    public List<QuestionResponseDto> getQuestionWithModule(Long id) {
        List<Question> questions=StreamSupport
                .stream(questionRepository.findByModuleId(id).spliterator(),false)
                .collect(Collectors.toList());
        return mapper.questionToQuestionResponseDtos(questions);
    }

    @Override
    public List<QuestionResponseDto> getQuestionWithText(Long id) {
        List<Question> questions=StreamSupport
                .stream(questionRepository.findByTextQuestionId(id).spliterator(),false)
                .collect(Collectors.toList());
        return mapper.questionToQuestionResponseDtos(questions);
    }

    @Override
    public QuestionResponseDto getQuestionWithAnswer(Long id) {
        Question question= getQuestionSelf(id);
        //return mapper.questionToQuestionResponseDto(question);
        return mapper.questionWithAnswerResponseDto(question);
    }



    @Override
    public QuestionResponseDto getQuestion(Long id) {
        Question question= getQuestionSelf(id);
        return mapper.questionToQuestionResponseDto(question);
    }

    @Override
    public Question getQuestionSelf(Long id) {
        return questionRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("cannot find question with id:" +id));
    }


    @Override
    public QuestionResponseDto updateQuestion(Long id, QuestionRequestDto requestDto) {
        Question question= getQuestionSelf(id);
        if(requestDto.getModuleId()!=null){
            Module module= moduleService.getModuleSelf(requestDto.getModuleId());
            question.setModule(module);
        }
        if(requestDto.getQuizId()!=null){
            Quiz quiz= quizService.getQuizSelf(requestDto.getQuizId());
            question.setQuiz(quiz);
        }
        if(requestDto.getTextQuestionId()!=null){
            TextQuestion textQuestion= textQuestionService.getTextQuestionSelf(requestDto.getTextQuestionId());
            question.setTextQuestion(textQuestion);
        }
       // question.setTextQuestionId(requestDto.getTextQuestionId());
        question.setQuestionText(requestDto.getQuestionText());
        question.setStatus(requestDto.isStatus());
        questionRepository.save(question);
        return mapper.questionToQuestionResponseDto(question);
    }

    @Override
    public Boolean deleteQuestion(Long id) {
        Optional<Question> question=questionRepository.findById(id);

        if(question.isPresent()){
            questionRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
