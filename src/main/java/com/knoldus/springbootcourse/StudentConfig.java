package com.knoldus.springbootcourse;

import com.knoldus.springbootcourse.dao.StudentRepository;
import com.knoldus.springbootcourse.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student mohit = new Student(
                    "Mohit",
                    LocalDate.of(1996, Month.MAY, 25),
                    "mohit.saxena@knoldus.com");

            Student nitin = new Student(
                    "Nitin",
                    LocalDate.of(1996, Month.MAY, 25),
                    "nitin.mishra@knoldus.com");

            studentRepository.saveAll(List.of(mohit, nitin));
        };
    }
}
