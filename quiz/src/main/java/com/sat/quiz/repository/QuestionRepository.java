package com.sat.quiz.repository;

import com.sat.quiz.entity.Question;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Long> {
    @EntityGraph(attributePaths = {"answers","module","module.section","quiz"})
    List<Question> findByModuleId(Long id);

    @EntityGraph(attributePaths = {"answers","module","module.section","quiz"})
    List<Question> findByTextQuestionId(Long id);
    @EntityGraph(attributePaths = {"answers","module","module.section","quiz"})
    List<Question> findAllByTextQuestionIdNotNull();

    List<Question> findAllByTextQuestionIdIsNull();


    @EntityGraph(attributePaths = {"answers","module","module.section","quiz"})
    List<Question> findAll();

    @EntityGraph(attributePaths = {"answers","module","module.section","quiz"})
    List<Question> findAllByQuizIdAndModuleIdAndTextQuestionIsNull(Long quizId,Long moduleId);

}
