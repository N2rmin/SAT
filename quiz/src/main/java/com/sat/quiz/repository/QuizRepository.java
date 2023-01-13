package com.sat.quiz.repository;

import com.sat.quiz.entity.Quiz;
import com.sat.quiz.entity.Selection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz,Long> {
}
