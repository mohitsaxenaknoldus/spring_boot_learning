package com.knoldus.springbootcourse.controller;

import com.knoldus.springbootcourse.entity.Student;
import com.knoldus.springbootcourse.service.GetStudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final GetStudentServiceImpl getStudentService;

    @Autowired
    public StudentController(GetStudentServiceImpl getStudentService) {

        this.getStudentService = getStudentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return getStudentService.getStudents();
    }

    @PostMapping
    public @ResponseBody void registerNewStudent(@RequestBody Student student){
        getStudentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        getStudentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable Long studentId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email){

        getStudentService.updateStudent(studentId, name, email);
    }
}
