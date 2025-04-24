package com.example.school.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.school.Entity.Teacher;
import com.example.school.Service.TeacherService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    private TeacherService teacherservice;

    public TeacherController(TeacherService teacherservice) {
        this.teacherservice = teacherservice;
    }
    @PostMapping
    public Teacher addTeacher(@Valid @RequestBody Teacher teacher)
    {
        return teacherservice.saveTeacher(teacher);
    }
    @GetMapping
    public List<Teacher> getAllteacher()
    {
        return teacherservice.getTeacher();
    }
    @GetMapping("/{id}")
    public Teacher getTeacherById(@PathVariable Long id) {
        return teacherservice.getTeacherById(id);
    }

}
