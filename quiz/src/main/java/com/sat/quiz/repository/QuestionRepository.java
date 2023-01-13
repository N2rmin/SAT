package com.sat.quiz.repository;

import com.sat.quiz.entity.Answer;
import com.sat.quiz.entity.Module;
import com.sat.quiz.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Long> {
    List<Question> findByModuleId(Long id);

    List<Question> findByTextQuestionId(Long id);

}
