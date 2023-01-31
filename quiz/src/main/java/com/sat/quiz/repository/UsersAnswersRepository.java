package com.sat.quiz.repository;

import com.sat.quiz.entity.UsersAnswers;
import com.sat.quiz.entity.Variant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsersAnswersRepository extends JpaRepository<UsersAnswers,Long> {
   // @EntityGraph(attributePaths = {"modules"})
    List<UsersAnswers> findAll();

 //   @EntityGraph(attributePaths = {"modules"})
    Optional<UsersAnswers> findById(Long id);
}
