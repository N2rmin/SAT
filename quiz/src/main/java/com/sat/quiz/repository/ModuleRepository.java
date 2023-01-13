package com.sat.quiz.repository;

import com.sat.quiz.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleRepository  extends JpaRepository<Module,Long> {
}
