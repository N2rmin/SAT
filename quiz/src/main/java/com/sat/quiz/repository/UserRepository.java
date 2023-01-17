package com.sat.quiz.repository;

import com.sat.quiz.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Long> {
    Users findByUsername(String username);
}
