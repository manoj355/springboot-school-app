package com.example.school.Service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.school.Entity.Student;
import com.example.school.Entity.Teacher;
import com.example.school.Repository.CourseRepository;
import com.example.school.Repository.StudentRepository;
import com.example.school.Repository.TeacherRepository;

@Service
public class StudentService {
    private StudentRepository studentrepo;
    private TeacherRepository teacherrepo;
    private CourseRepository courserepo;

    
   
    public StudentService(StudentRepository studentrepo, TeacherRepository teacherrepo, CourseRepository courserepo) {
        this.studentrepo = studentrepo;
        this.teacherrepo = teacherrepo;
        this.courserepo = courserepo;
    }
    public Student savestudent(Student student)
    {
        return studentrepo.save(student);
    }
    public List<Student> getStudent()
    {
        return studentrepo.findAll();
    }
    public List<Student> getStudentByTeacherId(Long Id)
    {
        Teacher teacher =teacherrepo.findById(Id).orElse(null);
        if (teacher != null) {
            System.out.println("Student list: " + teacher.getStudent());
        }
        
        return teacher!=null? teacher.getStudent():new ArrayList<>();
    }

    
}
