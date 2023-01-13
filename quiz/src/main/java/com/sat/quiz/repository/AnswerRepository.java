package com.sat.quiz.repository;

import com.sat.quiz.entity.Answer;
import com.sat.quiz.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AnswerRepository extends JpaRepository<Answer,Long> {

    List<Answer> findByQuestionId(Long id);


    Answer findByIdAndQuestion_Id(Long id,Long questionId);
}
