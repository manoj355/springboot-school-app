package com.example.school.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.school.Entity.Course;
import com.example.school.Service.CourseService;



@RestController
@RequestMapping("/course")
public class CourseController {
    private CourseService courseservice;
    
    public CourseController(CourseService courseservice) {
        this.courseservice = courseservice;
    }

    @PostMapping
    public Course addCourse(@RequestBody Course course)
    {
        return courseservice.saveCourse(course);
    }
    @GetMapping
    public List<Course> getAllCourse()
    {
        return courseservice.getAllCourses();
    }
    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id)
    {
        return courseservice.getCourseById(id);
    }
    
}
