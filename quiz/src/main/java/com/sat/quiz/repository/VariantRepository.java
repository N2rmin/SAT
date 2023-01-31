package com.sat.quiz.repository;

import com.sat.quiz.entity.Variant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VariantRepository extends JpaRepository<Variant,Long> {
   // @EntityGraph(attributePaths = {"modules"})
    List<Variant> findAll();

 //   @EntityGraph(attributePaths = {"modules"})
    Optional<Variant> findById(Long id);
}
