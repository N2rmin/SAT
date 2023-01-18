package com.sat.quiz.repository;

import com.sat.quiz.entity.Question;
import com.sat.quiz.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultRepository extends JpaRepository<Result,Long> {


}
