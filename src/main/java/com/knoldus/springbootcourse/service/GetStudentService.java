package com.knoldus.springbootcourse.service;

import com.knoldus.springbootcourse.entity.Student;

import java.util.List;

public interface GetStudentService {
    public List<Student> getStudents();

    void addNewStudent(Student student);

    void deleteStudent(Long studentId);

    void updateStudent(Long studentId, String name, String email);
}
