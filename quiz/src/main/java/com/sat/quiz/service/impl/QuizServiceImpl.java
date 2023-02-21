package com.sat.quiz.service.impl;

import com.sat.quiz.dto.requestDto.QuizRequestDto;
import com.sat.quiz.dto.responseDto.QuizResponseDto;

import com.sat.quiz.entity.Quiz;

import com.sat.quiz.repository.QuizRepository;
import com.sat.quiz.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {
    private final QuizRepository quizRepository;
    private final ModelMapper modelMapper;



    @Override
    public QuizResponseDto addQuiz(QuizRequestDto requestDto) {
        Quiz quiz=modelMapper.map(requestDto,Quiz.class);

        quiz.setCreatedDate(new Date());
        quiz.setCreatedBy("Narmin");

        quiz=quizRepository.save(quiz);

        return modelMapper.map(quizRepository.save(quiz),QuizResponseDto.class );
    }

    @Override
    public List<QuizResponseDto> getQuizs() {
        List<Quiz> quizs=quizRepository.findAll();
        List<QuizResponseDto> quizResponseDtos=quizs.stream().map(quiz -> modelMapper.map(quiz,QuizResponseDto.class)).collect(Collectors.toList());
        return quizResponseDtos;
    }

    @Override
    public QuizResponseDto getQuiz(Long id) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        if(quiz.isPresent()){
            return modelMapper.map(quiz.get(),QuizResponseDto.class);
        }
        throw new RuntimeException("Quiz tapilmadi") ;
    }

    @Override
    public Quiz getQuizSelf(Long id) {
        return quizRepository.findById(id).orElseThrow(()->new IllegalArgumentException("could not find quiz with id:"+id));
    }

    @Override
    public QuizResponseDto updateQuiz(Long id, QuizRequestDto requestDto) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        if(quiz.isPresent()){
            quiz.get().setName(requestDto.getName());
            quiz.get().setStatus(requestDto.isStatus());
            quiz.get().setUpdateDate(new Date());
            quiz.get().setUpdatedBy("Narmin");


            return modelMapper.map(quizRepository.save(quiz.get()),QuizResponseDto.class);
        }
        throw new RuntimeException("Quiz tapilmadi") ;
    }

    @Override
    public Boolean deleteQuiz(Long id) {
        Optional<Quiz> quiz=quizRepository.findById(id);

        if(quiz.isPresent()){
            quiz.get().setStatus(false);
            return true;
        }
        return false;
    }


}
