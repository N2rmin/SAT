package com.sat.quiz.repository;

import com.sat.quiz.entity.Question;
import com.sat.quiz.entity.TextQuestion;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TextQuestionRepository extends JpaRepository<TextQuestion,Long> {

    @EntityGraph(attributePaths = {"questions","questions.answers"})
    List<TextQuestion> findAll();
}
