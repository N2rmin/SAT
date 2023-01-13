package com.sat.quiz.repository;

import com.sat.quiz.entity.TextQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TextQuestionRepository extends JpaRepository<TextQuestion,Long> {
}
