package com.sat.quiz.dto;

import com.sat.quiz.dto.responseDto.*;
import com.sat.quiz.entity.*;
import com.sat.quiz.entity.Module;

import java.util.*;

public class mapper {
    public static ModuleResponseDto moduleToModuleResponseDto(Module module){
        ModuleResponseDto moduleResponseDto=new ModuleResponseDto();
        moduleResponseDto.setId(module.getId());
        moduleResponseDto.setName(module.getName());
        moduleResponseDto.setSectionNames(Collections.singletonList(module.getSection().getName()));
    return moduleResponseDto;
    }

    public static List<ModuleResponseDto> moduleToModuleResponseDtos(List<Module> modules){
        List<ModuleResponseDto> moduleResponseDtos=new ArrayList<>();
        for(Module module:modules){
            moduleResponseDtos.add(moduleToModuleResponseDto(module));
        }
        return moduleResponseDtos;
    }

    public static QuestionResponseDto questionToQuestionResponseDto(Question question){
        QuestionResponseDto questionResponseDto= new QuestionResponseDto();
        questionResponseDto.setId(question.getId());
        questionResponseDto.setQuestionText(question.getQuestionText());
        if(question.getTextQuestion()!=null){
            questionResponseDto.setTextQuestion(Collections.singletonList(question.getTextQuestion().getTextContent()));

        }

        questionResponseDto.setModuleNames(Collections.singletonList(question.getModule().getName()));
        questionResponseDto.setQuizNames(Collections.singletonList(question.getQuiz().getName()));
        return questionResponseDto;

    }


    public static List<QuestionResponseDto> questionToQuestionResponseDtos(List<Question> questions){
        List<QuestionResponseDto> questionResponseDtos=new ArrayList<>();
        for (Question question:questions){
            questionResponseDtos.add(questionToQuestionResponseDto(question));
        }
        return questionResponseDtos;
    }

    public static ResultResponseDto resultToResultResponseDto(Result result){
        ResultResponseDto responseDto= new ResultResponseDto();
        responseDto.setId(result.getId());
        responseDto.setQuizNames(Collections.singletonList(result.getQuiz().getName()));


        responseDto.setScore(result.getScore());
        responseDto.setStatus(result.getStatus());
        responseDto.setUsername(result.getUsername());
        return responseDto;

    }


 /*   public static List<ResultResponseDto> resultToResultResponseDtos(List<Question> questions){
        List<QuestionResponseDto> questionResponseDtos=new ArrayList<>();
        for (Question question:questions){
            questionResponseDtos.add(questionToQuestionResponseDto(question));
        }
        return questionResponseDtos;
    }*/

    public static AnswerResponseDto answerToAnswerResponseDto(Answer answer){
        AnswerResponseDto answerResponseDto = new AnswerResponseDto();
        answerResponseDto.setAnswerText(answer.getAnswerText());
        answerResponseDto.setIsTrue(answer.getIsTrue());
        answerResponseDto.setStatus(answer.getStatus());
        answerResponseDto.setQuestionText(Collections.singletonList(answer.getQuestion().getQuestionText()));
        return answerResponseDto;
    }

    public static List<AnswerResponseDto> answerToAnswerResponseDtos(List<Answer> answers){
        List<AnswerResponseDto> answerResponseDtos=new ArrayList<>();
        for (Answer answer:answers){
            answerResponseDtos.add(answerToAnswerResponseDto(answer));
        }
        return answerResponseDtos;
    }

    public static QuestionResponseDto questionWithAnswerResponseDto(Question question){
        QuestionResponseDto questionResponseDto= new QuestionResponseDto();
        questionResponseDto.setId(question.getId());
        questionResponseDto.setQuestionText(question.getQuestionText());
       // questionResponseDto.setTextQuestionId(question.getTextQuestionId());
        questionResponseDto.setModuleNames(Collections.singletonList(question.getModule().getName()));
        questionResponseDto.setQuizNames(Collections.singletonList(question.getQuiz().getName()));
        if(question.getTextQuestion()!=null){
            questionResponseDto.setTextQuestion(Collections.singletonList(question.getTextQuestion().getTextContent()));

        }
        Map<Long,String> answerText=new HashMap<>();
        List<Answer> answers=question.getAnswers();
        for (Answer answer:answers){
            answerText.put(answer.getId(),answer.getAnswerText());
        }
        questionResponseDto.setAnswerText(answerText);

        return questionResponseDto;

    }
    public static List<QuestionResponseDto> questionWithAnswerResponseDtos(List<Question> questions){
        List<QuestionResponseDto> questionResponseDtos=new ArrayList<>();
        for (Question question:questions){
            questionResponseDtos.add(questionWithAnswerResponseDto(question));

        }
        return questionResponseDtos;
    }


    public static TextQuestionResponseDto textQuestionToTextQuestionResponseDto(TextQuestion textQuestion){
        TextQuestionResponseDto textQuestionResponseDto= new TextQuestionResponseDto();
        textQuestionResponseDto.setId(textQuestion.getId());
        textQuestionResponseDto.setStatus(textQuestion.isStatus());
        textQuestionResponseDto.setTextContent(textQuestion.getTextContent());
        Map<Long,String> questionText=new HashMap<>();
        List<Question> questions=textQuestion.getQuestions();
        for (Question question:questions){
            questionText.put(question.getId(),question.getQuestionText());
        }

        textQuestionResponseDto.setQuestions(questionText);
        return textQuestionResponseDto;
    }

    public static List<TextQuestionResponseDto> textQuestionToTextQuestionResponseDtos(List<TextQuestion> textQuestions){
        List<TextQuestionResponseDto> textQuestionResponseDtos=new ArrayList<>();
        for (TextQuestion textQuestion:textQuestions){
            textQuestionResponseDtos.add(textQuestionToTextQuestionResponseDto(textQuestion));

        }
        return textQuestionResponseDtos;
    }

    public static TextQuestionResponseDto textQuestionToTextQuestionWithAnswerResponseDto(TextQuestion textQuestion){
        TextQuestionResponseDto textQuestionResponseDto= new TextQuestionResponseDto();
        textQuestionResponseDto.setId(textQuestion.getId());
        textQuestionResponseDto.setStatus(textQuestion.isStatus());
        textQuestionResponseDto.setTextContent(textQuestion.getTextContent());
        Map<Long,String> questionText=new HashMap<>();
        Map<Long,String> answerText=new HashMap<>();

        List<Question> questions=textQuestion.getQuestions();
        for (Question question:questions){
            questionText.put(question.getId(),question.getQuestionText());
            for (Answer answer:question.getAnswers()){
                answerText.put(answer.getId(),answer.getAnswerText());
            }
            textQuestionResponseDto.setAnswerText(answerText);
        }

        textQuestionResponseDto.setQuestions(questionText);
        return textQuestionResponseDto;
    }

    public static List<TextQuestionResponseDto> textQuestionToTextQuestionWithAnswerResponseDtos(List<TextQuestion> textQuestions){
        List<TextQuestionResponseDto> textQuestionResponseDtos=new ArrayList<>();
        for (TextQuestion textQuestion:textQuestions){
            textQuestionResponseDtos.add(textQuestionToTextQuestionWithAnswerResponseDto(textQuestion));

        }
        return textQuestionResponseDtos;
    }

}

