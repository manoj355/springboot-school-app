package com.example.school.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.school.Entity.Student;
import com.example.school.Service.StudentService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/student")
public class StudentController {
    private StudentService studentservice;

    public StudentController(StudentService studentservice) {
        this.studentservice = studentservice;
    }
    @PostMapping
    public Student saveStudent(@Valid @RequestBody Student student)
    {
        return studentservice.savestudent(student);
    }
    @GetMapping
    public List<Student> getStudent()
    {
        return studentservice.getStudent();
    }
    @GetMapping("/byteacher/{id}")
    public List<Student> getStudenByTeacher(@PathVariable Long id)
    {
        return studentservice.getStudentByTeacherId(id);
    }
    
}
