package com.knoldus.springbootcourse;

import com.knoldus.springbootcourse.entity.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
public class SpringbootcourseApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringbootcourseApplication.class, args);
    }
}
