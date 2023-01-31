package com.sat.quiz.service.impl;

import com.sat.quiz.dto.mapper;
import com.sat.quiz.dto.requestDto.ResultRequestDto;
import com.sat.quiz.dto.responseDto.ModuleResponseDto;
import com.sat.quiz.dto.responseDto.ResultResponseDto;
import com.sat.quiz.entity.*;
import com.sat.quiz.entity.Module;
import com.sat.quiz.repository.AnswerRepository;
import com.sat.quiz.repository.ResultRepository;
import com.sat.quiz.repository.UsersAnswersRepository;
import com.sat.quiz.service.ModuleService;
import com.sat.quiz.service.ResultService;
import com.sat.quiz.service.QuizService;
import lombok.RequiredArgsConstructor;
import javax.validation.ConstraintViolationException;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLData;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ResultServiceImpl implements ResultService {
    private  final ResultRepository resultRepository;
    private final QuizService quizService;

    private final ExaminerServiceImpl examinerService;

    private final UsersAnswersRepository usersAnswersRepository;
    private final AnswerRepository answerRepository;


    private final ModelMapper modelMapper;


    @Transactional
    @Override
    public ResultResponseDto addResult(ResultRequestDto requestDto) {
        Result result= new Result();

        if (requestDto.getQuizId()==null){
            throw  new IllegalArgumentException("result at least one quiz");
        }

        Quiz quiz= quizService.getQuizSelf(requestDto.getQuizId());
        result.setQuiz(quiz);

        if (requestDto.getExaminerId()==null){
            throw  new IllegalArgumentException("result at least one examiner");
        }

        Examiner examiner= examinerService.getExaminerSelf(requestDto.getExaminerId());
        result.setExaminer(examiner);

        LinkedHashSet<Long> answerIds= new LinkedHashSet<>();
        int score =0;
        Long questionId;
        Long answerId;
        for(Map.Entry<Long,Long> entry:requestDto.getQuestionAnswer().entrySet()){
            System.out.println(entry);
            questionId=entry.getKey();
            answerId=entry.getValue();
            answerIds.add(answerId);


           Answer answer= answerRepository.findByIdAndQuestion_Id(answerId,questionId);
           if(answer.getIsTrue()){
               score++;
           }



        }

        result.setScore(score);
     //   result.setUsername(requestDto.getUsername());

        System.out.println(score);
        //TextResult textResult= textResultService.getTextResultSelf(requestDto.getTextResultId());
       // result.setTextResultId(requestDto.getTextResultId());

        result.setStatus(requestDto.getStatus());


        resultRepository.save(result);

        System.out.println(result.getId());

            for (long id: answerIds){
                UsersAnswers usersAnswers= new UsersAnswers();

                usersAnswers.setResult(result);

                usersAnswers.setUserVariantId(id);
                System.out.println(id);

                usersAnswersRepository.save(usersAnswers);
            }




        //
        //
        //  System.out.println("sfdfdsfddfe");
        return mapper.resultToResultResponseDto(result);



    }

    @Override
    public List<ResultResponseDto> getResults() {
        List<Result> results=StreamSupport
                .stream(resultRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
        return null;//mapper.resultToResultResponseDtos(results);

    }

   /* @Override
    public List<ResultResponseDto> getResultsWithAnswer() {
        List<Result> results=StreamSupport
                .stream(resultRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
        return mapper.resultWithAnswerResponseDtos(results);
    }

    @Override
    public List<ResultResponseDto> getResultWithModule(Long id) {
        List<Result> results=StreamSupport
                .stream(resultRepository.findByModuleId(id).spliterator(),false)
                .collect(Collectors.toList());
        return mapper.resultToResultResponseDtos(results);
    }

    @Override
    public List<ResultResponseDto> getResultWithText(Long id) {
        List<Result> results=StreamSupport
                .stream(resultRepository.findByTextResultId(id).spliterator(),false)
                .collect(Collectors.toList());
        return mapper.resultToResultResponseDtos(results);
    }*/

    @Override
    public ResultResponseDto getResultWithAnswer(Long id) {
        Result result= getResultSelf(id);
        //return mapper.resultToResultResponseDto(result);
        return null;//mapper.resultWithAnswerResponseDto(result);
    }

    @Override
    public List<ResultResponseDto> getResultsWithAnswer() {
        return null;
    }


    @Override
    public ResultResponseDto getResult(Long id) {
        Result result= getResultSelf(id);
        return null;// mapper.resultToResultResponseDto(result);
    }

    @Override
    public Result getResultSelf(Long id) {
        return resultRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("cannot find result with id:" +id));
    }


    @Override
    public ResultResponseDto updateResult(Long id, ResultRequestDto requestDto) {
        Result result= getResultSelf(id);

        if(requestDto.getQuizId()!=null){
        //    Quiz quiz= quizService.getQuizSelf(requestDto.getQuizId());
          //  result.setQuiz(quiz);
        }

       // result.setTextResultId(requestDto.getTextResultId());
        result.setStatus(requestDto.getStatus());
        resultRepository.save(result);
        return null;//mapper.resultToResultResponseDto(result);
    }

    @Override
    public Boolean deleteResult(Long id) {
        Optional<Result> result=resultRepository.findById(id);

        if(result.isPresent()){
            resultRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<ResultResponseDto> getResultWithModule(Long id) {
        return null;
    }

    @Override
    public List<ResultResponseDto> getResultWithText(Long id) {
        return null;
    }


}
