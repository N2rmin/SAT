package com.sat.quiz.repository;

import com.sat.quiz.entity.Question;
import com.sat.quiz.entity.Result;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface ResultRepository extends JpaRepository<Result,Long> {

    Result findByExaminerIdAndModuleId(Long examinerId,Long moduleId);

    @EntityGraph(attributePaths = {"module"})
    List<Result>  findByExaminerIdAndModuleIdInAndQuizId(Long examiner_id, Collection<Long> moduleId, Long quiz_id);

}
