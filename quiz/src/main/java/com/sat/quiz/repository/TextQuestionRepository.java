package com.sat.quiz.repository;

import com.sat.quiz.entity.TextQuestion;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TextQuestionRepository extends JpaRepository<TextQuestion,Long> {

    @EntityGraph(attributePaths = {"questions","questions.answers","questions.module","questions.module.section","questions.quiz"})
    List<TextQuestion> findAll();


    @EntityGraph(attributePaths = {"questions","questions.answers","questions.module","questions.module.section","questions.quiz"})
    Optional<TextQuestion> findById(Long id);

    @EntityGraph(attributePaths = {"questions","questions.answers","questions.module","questions.module.section","questions.quiz"})
    List<TextQuestion> findAllByQuestions_QuizIdAndQuestions_ModuleId(Long quizId,Long moduleId);

  //  List<TextQuestion> findAllByQuizIdAndModuleIdAndTextQuestionIsNull(Long quizId,Long moduleId);

}
