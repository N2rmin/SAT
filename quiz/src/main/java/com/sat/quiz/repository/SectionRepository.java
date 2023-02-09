package com.sat.quiz.repository;

import com.sat.quiz.entity.Question;
import com.sat.quiz.entity.Section;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SectionRepository extends JpaRepository<Section,Long> {
    @EntityGraph(attributePaths = {"modules"})
    List<Section> findAll();

   @EntityGraph(attributePaths = {"modules"})
    Optional<Section> findById(Long id);
}
