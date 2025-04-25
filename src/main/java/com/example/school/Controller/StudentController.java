package com.example.school.Controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.school.DTO.StudentPageResponse;
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
    @GetMapping("/filter")
    public Page<Student> getFilteredStudent(
        @RequestParam(required = false) String location,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size,
        @RequestParam(defaultValue = "id") String sortBy,
        @RequestParam(defaultValue = "asc") String direction
    ) {
        return studentservice.getFilteredStudent(location, page, size, sortBy, direction);
    }
    

    @GetMapping("/filters")
    public StudentPageResponse getFilteredStudents(@RequestParam(required = false)String location,
                                                    @RequestParam(defaultValue = "0")int page,
                                                    @RequestParam(defaultValue = "5")int size,
                                                    @RequestParam(defaultValue = "id")String id,
                                                    @RequestParam(defaultValue = "asc")String direction){
                                                        return studentservice.getFilteredStudents(location, page, size, id, direction);
                                                    }
    
}
