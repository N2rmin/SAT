package com.sat.quiz.service.impl;

import com.sat.quiz.dto.mapper;
import com.sat.quiz.dto.requestDto.AnswerRequestDto;
import com.sat.quiz.dto.responseDto.AnswerResponseDto;
import com.sat.quiz.dto.responseDto.ModuleResponseDto;
import com.sat.quiz.entity.Module;
import com.sat.quiz.entity.Answer;
import com.sat.quiz.entity.Question;
import com.sat.quiz.entity.Quiz;
import com.sat.quiz.repository.AnswerRepository;
import com.sat.quiz.service.ModuleService;
import com.sat.quiz.service.AnswerService;
import com.sat.quiz.service.QuestionService;
import com.sat.quiz.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {
    private  final AnswerRepository answerRepository;


    private final QuestionService questionService;

    private final ModelMapper modelMapper;

    @Override
    public AnswerResponseDto addAnswer(AnswerRequestDto requestDto) {
        Answer answer= new Answer();
        if (requestDto.getQuestionId()==null){
            throw  new IllegalArgumentException("answer at least one question");
        }
        Question question= questionService.getQuestionSelf(requestDto.getQuestionId());
        answer.setQuestion(question);

        answer.setAnswerText(requestDto.getAnswerText());
        answer.setStatus(requestDto.getStatus());
        answer.setIsTrue(requestDto.getIsTrue());
        answerRepository.save(answer);
        return modelMapper.map(answer,AnswerResponseDto.class);

    }

    @Override
    public List<AnswerResponseDto> getAnswers() {

        List<AnswerResponseDto> list = new ArrayList<>();

        answerRepository.findAll().stream().forEach(obj->{
            list.add(modelMapper.map(obj,AnswerResponseDto.class));
        });


        return list;


    }


//    @Override
//    public List<AnswerResponseDto>  getAnswersWithQuestion(Long id) {
//        List<Answer> answers=StreamSupport
//                .stream(answerRepository.findByQuestionId(id).spliterator(),false)
//                .collect(Collectors.toList());
//        return modelMapper.map(answers,AnswerResponseDto.class);
//    }

    @Override
    public AnswerResponseDto getAnswer(Long id) {
        Answer answer= getAnswerSelf(id);
        return modelMapper.map(answer,AnswerResponseDto.class);
    }

    @Override
    public Answer getAnswerSelf(Long id) {
        return answerRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("cannot find answer with id:" +id));
    }


    @Override
    public AnswerResponseDto updateAnswer(Long id, AnswerRequestDto requestDto) {
        Answer answer= getAnswerSelf(id);
        if(requestDto.getQuestionId()!=null){
            Question question= questionService.getQuestionSelf(requestDto.getQuestionId());
            answer.setQuestion(question);
        }

        answer.setAnswerText(requestDto.getAnswerText());
        answer.setStatus(requestDto.getStatus());
        answer.setIsTrue(requestDto.getIsTrue());
        answerRepository.save(answer);
        return modelMapper.map(answer,AnswerResponseDto.class);
    }

    @Override
    public Boolean deleteAnswer(Long id) {
        Optional<Answer> answer=answerRepository.findById(id);

        if(answer.isPresent()){
            answerRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
