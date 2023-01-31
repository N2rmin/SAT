package com.sat.quiz.service.impl;

import com.sat.quiz.dto.mapper;
import com.sat.quiz.dto.requestDto.QuestionRequestDto;
import com.sat.quiz.dto.responseDto.AnswerResponseDto;
import com.sat.quiz.dto.responseDto.ExamResponseDto;
import com.sat.quiz.dto.responseDto.QuestionResponseDto;
import com.sat.quiz.dto.responseDto.TextQuestionResponseDto;
import com.sat.quiz.entity.*;
import com.sat.quiz.entity.Module;
import com.sat.quiz.repository.QuestionRepository;
import com.sat.quiz.repository.TextQuestionRepository;
import com.sat.quiz.service.ModuleService;
import com.sat.quiz.service.QuestionService;
import com.sat.quiz.service.QuizService;
import com.sat.quiz.service.TextQuestionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.LongFunction;
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
        question.setOrderNumber(requestDto.getOrderNumber());
        questionRepository.save(question);
        return modelMapper.map(question, QuestionResponseDto.class);

    }

    @Override
    public List<QuestionResponseDto> getQuestions() {

        List<QuestionResponseDto> list = new ArrayList<>();

        questionRepository.findAllByOrderByIdAsc().stream().forEach(obj->{
            list.add(modelMapper.map(obj,QuestionResponseDto.class));
        });

        return list;


    }

    @Override
    public List<QuestionResponseDto> getQuizAndModuleQuestions(Long quizId, Long moduleId) {

        List<QuestionResponseDto> list = new ArrayList<>();

        questionRepository.findAllByQuizIdAndModuleIdAndTextQuestionIsNull(quizId,moduleId).stream().forEach(obj->{
            list.add(modelMapper.map(obj,QuestionResponseDto.class));
        });

        return list;


    }

//    @Override
//    public List<QuestionResponseDto> getQuestionsWithAnswer() {
//        List<Question> questions=StreamSupport
//                .stream(questionRepository.findAll().spliterator(),false)
//                .collect(Collectors.toList());
//        return mapper.questionWithAnswerResponseDtos(questions);
//    }

//    @Override
//    public List<QuestionResponseDto> getQuestionWithModule(Long id) {
//        List<Question> questions=StreamSupport
//                .stream(questionRepository.findByModuleId(id).spliterator(),false)
//                .collect(Collectors.toList());
//        return mapper.questionToQuestionResponseDtos(questions);
//    }

//    @Override
//    public List<QuestionResponseDto> getQuestionWithText(Long id) {
//        List<Question> questions=StreamSupport
//                .stream(questionRepository.findByTextQuestionId(id).spliterator(),false)
//                .collect(Collectors.toList());
//        return mapper.questionToQuestionResponseDtos(questions);
//    }

//    @Override
//    public QuestionResponseDto getQuestionWithAnswer(Long id) {
//        Question question= getQuestionSelf(id);
//        //return mapper.questionToQuestionResponseDto(question);
//        return mapper.questionWithAnswerResponseDto(question);
//    }



    @Override
    public QuestionResponseDto getQuestion(Long id) {
        Question question= getQuestionSelf(id);
        return modelMapper.map(question, QuestionResponseDto.class);
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
        question.setOrderNumber(requestDto.getOrderNumber());
       // question.setTextQuestionId(requestDto.getTextQuestionId());
        question.setQuestionText(requestDto.getQuestionText());
        question.setStatus(requestDto.isStatus());
        questionRepository.save(question);
        return modelMapper.map(question, QuestionResponseDto.class);
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

    private final TextQuestionRepository textQuestionRepository;
    @Override
    public List<TextQuestionResponseDto> findAll() {
        TextQuestionResponseDto textQuestionResponseDto=modelMapper.map(textQuestionRepository.findById(1L).get(),TextQuestionResponseDto.class);
        return List.of(textQuestionResponseDto);
    }

    @Override
    public QuestionResponseDto getQuestionForExam(Long quizId, Long moduleId, int orderNumber, boolean answer) {
        System.out.println("1111");
        Question question;

         question=questionRepository.findByQuizIdAndModuleIdAndOrderNumber(quizId,moduleId,orderNumber);

        System.out.println(answer);
        if (!answer){
            System.out.println(answer);
            question.getAnswers().forEach(answer1 -> answer1.setIsTrue(null));
        }

        System.out.println("5555");
          //  QuestionResponseDto questionResponseDto= modelMapper.map(question, QuestionResponseDto.class);



      //  System.out.println("22222");

      //  System.out.println(question);
       // System.out.println("3333");

        return modelMapper.map(question, QuestionResponseDto.class);
    }

    @Override
    public List<Object> getQuestionOrderNumbers(Long quizId, Long moduleId) {

        System.out.println("1111");
        List<Object> orderNumbers= questionRepository.findAllOrderNumberByQuizIdAndModuleId(quizId,moduleId);

        System.out.println("22222");
        System.out.println(orderNumbers);
        System.out.println("33333");
        return orderNumbers;
    }


    public  ExamResponseDto   questionToExamResponseDto(Long moduleId) {
      ExamResponseDto examResponseDto=new ExamResponseDto();
        System.out.println("H0");

        List<Question> allQuestion = StreamSupport
                .stream(questionRepository.findByModuleId(moduleId).spliterator(), false)
                .collect(Collectors.toList());
        System.out.println("H1");

        System.out.println("H3");

        Map<Long, Object> Exam = new HashMap<>();
        Map<Long, String> textQuestion = new HashMap<>();

        //List<Question> questionWithtext;

        Set<Long> textIds = new HashSet<Long>();

        List<Question> questionWithText = StreamSupport
                .stream(questionRepository.findAllByTextQuestionIdNotNull().spliterator(), false).collect(Collectors.toList());

        for (Question question : questionWithText) {
            System.out.println(question.getTextQuestion().getId());
            textIds.add(question.getTextQuestion().getId());
        }
        ;
        System.out.println(textIds);

        for (Long id : textIds) {
            List<Question> questions = StreamSupport
                    .stream(questionRepository.findByTextQuestionId(id).spliterator(), false)
                    .collect(Collectors.toList());

            System.out.println("121");
            Exam.put(id,questions);
            System.out.println("23432");
        }
        System.out.println("23542332");
        System.out.println(Exam.keySet());
       // examResponseDto.setQuestionAnswer(Exam);
        return examResponseDto;
    }



//        TextQuestionResponseDto textQuestionResponseDto= new TextQuestionResponseDto();
//        textQuestionResponseDto.setId(textQuestion.getId());
//        textQuestionResponseDto.setStatus(textQuestion.isStatus());
//        textQuestionResponseDto.setTextContent(textQuestion.getTextContent());
//        Map<Long,String> questionText=new HashMap<>();
//        Map<Long,String> answerText=new HashMap<>();
//        Map<Long,Object> questionAnswer= new HashMap<>();
//
//        List<Question> questions=textQuestion.getQuestions();
//        for (Question question:questions){
//            questionText.put(question.getId(),question.getQuestionText());
//            for (Answer answer:question.getAnswers()){
//                answerText.put(answer.getId(),answer.getAnswerText());
//            }
//            questionAnswer.put(question.getId(),answerText);
//            textQuestionResponseDto.setAnswerText(answerText);
//        }
//
//        textQuestionResponseDto.setQuestions(questionText);





}
