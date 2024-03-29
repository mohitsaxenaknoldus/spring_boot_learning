package com.knoldus.springbootcourse.dao;

import com.knoldus.springbootcourse.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findStudentByEmail(String email);
    Optional<Student> findStudentById(Long id);
}
