package com.knoldus.springbootcourse.service;

import com.knoldus.springbootcourse.dao.StudentRepository;
import com.knoldus.springbootcourse.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class GetStudentServiceImpl implements GetStudentService{

    private final StudentRepository studentRepository;

    @Autowired
    public GetStudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getStudents() {

        return studentRepository.findAll();
    }

    @Override
    public void addNewStudent(Student student) {

        Optional<Student> optionalStudent = studentRepository
                .findStudentByEmail(student.getEmail());

        if(optionalStudent.isPresent()){
            throw new IllegalStateException("Email exists!");
        }

        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long studentId) {

        boolean exists = studentRepository.existsById(studentId);

        if(!exists){
            throw new IllegalStateException("Email doesn't exist!");
        }

        studentRepository.deleteById(studentId);
    }

    @Override
    @Transactional
    public void updateStudent(Long studentId, String name, String email) {

        Student student = studentRepository.findStudentById(studentId).orElseThrow(
                () -> new IllegalStateException("Student doesn't exist!"));

        if(name != null && name.length() > 0 && Objects.equals(student.getName(), name)){
            student.setName(name);
        }

        if(email != null && Objects.equals(student.getEmail(), email)){
            Optional<Student> optionalStudent = studentRepository.findStudentByEmail(email);

            if(optionalStudent.isPresent()){
                throw new IllegalStateException("Email already taken!");
            }

            student.setEmail(email);
        }
    }
}
