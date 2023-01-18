package com.sat.quiz.repository;

import com.sat.quiz.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
    Users findByUsername(String username);
}
