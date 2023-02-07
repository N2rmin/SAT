package com.sat.quiz.service.impl;

import com.sat.quiz.dto.mapper;
import com.sat.quiz.dto.requestDto.TextQuestionRequestDto;
import com.sat.quiz.dto.requestDto.TextQuestionRequestDto;
import com.sat.quiz.dto.responseDto.QuestionResponseDto;
import com.sat.quiz.dto.responseDto.TextQuestionResponseDto;
import com.sat.quiz.dto.responseDto.TextQuestionResponseDto;
import com.sat.quiz.entity.Question;
import com.sat.quiz.entity.TextQuestion;
import com.sat.quiz.entity.TextQuestion;
import com.sat.quiz.repository.TextQuestionRepository;
import com.sat.quiz.service.TextQuestionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class TextQuestionServiceImpl implements TextQuestionService {

   private final TextQuestionRepository textQuestionRepository;
    private final ModelMapper modelMapper;

    @Override
    public TextQuestionResponseDto addTextQuestion(TextQuestionRequestDto requestDto) {
        TextQuestion textQuestion= modelMapper.map(requestDto,TextQuestion.class);

        return modelMapper.map(textQuestionRepository.save(textQuestion),TextQuestionResponseDto.class);
    }


    @Override
    public List<TextQuestionResponseDto> getTextQuestions() {


        List<TextQuestionResponseDto> list = new ArrayList<>();

        textQuestionRepository.findAll().stream().forEach(obj->{
            list.add(modelMapper.map(obj,TextQuestionResponseDto.class));
        });

        return list;
    }

/*    @Override
    public List<TextQuestionResponseDto> getTextQuestionsWithQuizAndModule(Long quizId,Long moduleId) {


        List<TextQuestionResponseDto> list = new ArrayList<>();

        textQuestionRepository.findAllByQuestions_QuizIdAndQuestions_ModuleId(quizId,moduleId).stream().forEach(obj->{
            list.add(modelMapper.map(obj,TextQuestionResponseDto.class));
        });

        return list;
    }*/

    @Override
    public TextQuestionResponseDto getTextQuestion(Long id) {
        Optional<TextQuestion> textQuestion = textQuestionRepository.findById(id);
        if(textQuestion.isPresent()){
            return modelMapper.map(textQuestion.get(),TextQuestionResponseDto.class);
        }
        throw new RuntimeException("TextQuestion tapilmadi") ;
    }

    @Override
    public TextQuestion getTextQuestionSelf(Long id) {
        return textQuestionRepository.findById(id).orElseThrow(()->new IllegalArgumentException("could not find textQuestion with id:"+id));
    }

    @Override
    public TextQuestionResponseDto updateTextQuestion(Long id, TextQuestionRequestDto requestDto) {
        Optional<TextQuestion> textQuestion = textQuestionRepository.findById(id);
        if(textQuestion.isPresent()){
            textQuestion.get().setTextContent(requestDto.getTextContent());
            textQuestion.get().setStatus(requestDto.isStatus());
            textQuestion.get().setIsText(requestDto.getIsText());



            return modelMapper.map(textQuestionRepository.save(textQuestion.get()),TextQuestionResponseDto.class);
        }
        throw new RuntimeException("TextQuestion tapilmadi") ;
    }

    @Override
    public Boolean deleteTextQuestion(Long id) {
        Optional<TextQuestion> textQuestion=textQuestionRepository.findById(id);

        if(textQuestion.isPresent()){
            textQuestionRepository.deleteById(id);
            return true;
        }
        return false;
    }

//    @Override
//    public TextQuestionResponseDto getTextQuestionWithQuestion(Long id) {
//        TextQuestion textQuestion= getTextQuestionSelf(id);
//        //return mapper.questionToQuestionResponseDto(question);
//        return mapper.textQuestionToTextQuestionWithAnswerResponseDto(textQuestion);
//    }

//    @Override
//    public List<TextQuestionResponseDto> getTextQuestionsWithQuestion() {
//        List<TextQuestion> textQuestions= StreamSupport
//                .stream(textQuestionRepository.findAll().spliterator(),false)
//                .collect(Collectors.toList());
//        return mapper.textQuestionToTextQuestionWithAnswerResponseDtos(textQuestions);
//    }


}
