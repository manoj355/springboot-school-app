package com.example.school.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.school.Entity.Student;
import com.example.school.Entity.Teacher;
import com.example.school.Repository.TeacherRepository;

@Service
public class TeacherService {
    private TeacherRepository teacherrepo;

    public TeacherService(TeacherRepository teacherrepo) {
        this.teacherrepo = teacherrepo;
    }
    public Teacher saveTeacher(Teacher teacher)
    {
        return teacherrepo.save(teacher);
    }
    public List<Teacher> getTeacher()
    {
        return teacherrepo.findAll();
    }
    public List<Student> getStudentsByTeacherId(Long id) {
        Teacher teacher = teacherrepo.findById(id).orElse(null);
        return teacher != null ? teacher.getStudent() : new ArrayList<>();
    }
    public Teacher getTeacherById(Long id) {
        return teacherrepo.findById(id).orElse(null);
    }
    

    
}
