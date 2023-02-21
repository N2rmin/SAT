package com.sat.quiz.service.impl;

import com.sat.quiz.dto.responseDto.ExaminerResponseDto;
import com.sat.quiz.dto.responseDto.ModuleResponseDto;
import com.sat.quiz.dto.responseDto.ResultResponseDto;
import com.sat.quiz.dto.responseDto.result.UserScoreReportResponseDto;
import com.sat.quiz.dto.responseDto.result.UsersAnswersCountReportResponseDto;
import com.sat.quiz.dto.responseDto.result.UsersAnswersReportResponseDto;
import com.sat.quiz.entity.Answer;
import com.sat.quiz.entity.Examiner;
import com.sat.quiz.entity.Question;
import com.sat.quiz.entity.Result;
import com.sat.quiz.entity.UsersAnswers;
import com.sat.quiz.repository.ExaminerRepository;
import com.sat.quiz.repository.ModuleRepository;
import com.sat.quiz.repository.QuestionRepository;
import com.sat.quiz.repository.ResultRepository;
import com.sat.quiz.repository.UsersAnswersRepository;
import com.sat.quiz.service.ModuleService;
import com.sat.quiz.service.QuizService;
import com.sat.quiz.service.ReportService;
import com.sat.quiz.service.TextQuestionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private  final QuestionRepository questionRepository;
    private final ModuleService moduleService;

    private final ExaminerRepository examinerRepository;


    private final ResultRepository resultRepository;

private final ModuleRepository moduleRepository;
    private final UsersAnswersRepository usersAnswersRepository;
    private final QuizService quizService;

    private final TextQuestionService textQuestionService;

    private final ModelMapper modelMapper;

    @Override
    public List<UsersAnswersReportResponseDto> getUerAnswerReports() {
        return null;
    }

    @Override
    public UsersAnswersReportResponseDto getUerAnswerReport(Long id) {
        return null;
    }

    @Override
    public UsersAnswers getUerAnswerReportSelf(Long id) {
        return null;
    }

    @Override
    public UsersAnswersReportResponseDto getUserAnswers(Long quizId, Long moduleId, int orderNumber,String promoCode) {
        Question question;

        System.out.println(quizId);
        System.out.println(moduleId);
        System.out.println(orderNumber);
        Examiner examiner = examinerRepository.findByPromoCode(promoCode);
        Result result= resultRepository.findByExaminerIdAndModuleId(examiner.getId(),moduleId);
        System.out.println("1111");

        question=questionRepository.findByQuizIdAndModuleIdAndOrderNumber(quizId,moduleId,orderNumber);
        TreeSet<Answer> answers= new TreeSet<>(question.getAnswers());
        System.out.println("11143432");

        question.setAnswers(answers);
        System.out.println("22222222");

        UsersAnswers usersAnswers = usersAnswersRepository.findByResultIdAndOrderNumber(result.getId(), orderNumber);

        //  QuestionResponseDto questionResponseDto= modelMapper.map(question, QuestionResponseDto.class);


System.out.println("33333333333");

        UsersAnswersReportResponseDto usersAnswersReportResponseDto=  modelMapper.map(question, UsersAnswersReportResponseDto.class);
        System.out.println("444444444");

        System.out.println(usersAnswers.getUserVariantId());


        usersAnswersReportResponseDto.setUserAnswerId(usersAnswers.getUserVariantId());
        usersAnswersReportResponseDto.setUserOpenAnswer(usersAnswers.getOpenAnswer());
        usersAnswersReportResponseDto.setName(examiner.getName());
        usersAnswersReportResponseDto.setLastName(examiner.getLastName());
        System.out.println("555555555");

        //  System.out.println("22222");

        //  System.out.println(question);
        // System.out.println("3333");

        return usersAnswersReportResponseDto;
    }

    @Override
    public Boolean deleteUerAnswerReport(Long id) {
        return null;
    }

    @Override
    public  UserScoreReportResponseDto getUserCorrectAnswerCount(Long quizId, String promoCode) {

        Collection<Long>  ids=moduleRepository.findId();


        Examiner examiner = examinerRepository.findByPromoCode(promoCode);
       // List<Result> results= resultRepository.findByExaminerIdAndModuleIdInAndQuizId(examiner.getId(),longs,1L);

        System.out.println("terdst");

        System.out.println("---");

        UserScoreReportResponseDto userScoreReportResponseDto = modelMapper.map(examiner, UserScoreReportResponseDto.class);
        userScoreReportResponseDto.setExaminer(modelMapper.map(examiner, ExaminerResponseDto.class));

        List<UsersAnswersCountReportResponseDto> list = new ArrayList<>();




     resultRepository.findByExaminerIdAndModuleIdInAndQuizId(examiner.getId(),ids,  quizId).stream().forEach(obj->{
         list.add(modelMapper.map(obj,UsersAnswersCountReportResponseDto.class));
             });

     userScoreReportResponseDto.setUsersAnswersCountReportResponseDtos(list);
        System.out.println("1111---");

    /*    System.out.println(results.size());
        for (int i=0;i<results.size();i++){
            System.out.println(results.get(i).getId());
        }*/

        System.out.println("1111");



        return userScoreReportResponseDto;
    }
}
