package com.sat.quiz.repository;

import com.sat.quiz.entity.Answer;
import com.sat.quiz.entity.Question;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AnswerRepository extends JpaRepository<Answer,Long> {

    List<Answer> findByQuestionId(Long id);

    @EntityGraph(attributePaths = {"question"})
    List<Answer> findAll();

    //Answer findById(Long id)

    Answer findByIdAndQuestion_Id(Long id,Long questionId);

    Answer findByVariantIdAndQuestionOrderNumberAndQuestionModuleIdAndQuestionQuizId(Long id, int orderNumber,Long moduleId, Long quizId );

    Answer findByQuestionOrderNumberAndQuestionModuleIdAndQuestionQuizId(int orderNumber,Long moduleId, Long quizId );

}
