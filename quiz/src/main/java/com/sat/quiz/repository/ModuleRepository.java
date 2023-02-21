package com.sat.quiz.repository;

import com.sat.quiz.entity.Module;
import com.sat.quiz.entity.Question;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ModuleRepository  extends JpaRepository<Module,Long> {

    @EntityGraph(attributePaths = {"section"})
    List<Module> findAll();

    @EntityGraph(attributePaths = {"section"})
    Optional<Module> findById(Long id);

    @EntityGraph(attributePaths = {"section"})
    Optional<Module> findAllBySectionId(Long sectionId);

    @Query(value = "select id from module ", nativeQuery = true)
    Collection<Long> findId();
}
