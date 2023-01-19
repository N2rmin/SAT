package com.sat.quiz.repository;

import com.sat.quiz.entity.Module;
import com.sat.quiz.entity.Question;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModuleRepository  extends JpaRepository<Module,Long> {

    @EntityGraph(attributePaths = {"section"})
    List<Module> findAll();
}
