package com.example.school.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.school.Entity.Course;
import com.example.school.Repository.CourseRepository;

@Service
public class CourseService {
    private CourseRepository courserepo;
    
    public CourseService(CourseRepository courserepo) {
        this.courserepo = courserepo;
    }

    public Course saveCourse(Course course) {
        return courserepo.save(course);
    }

    public List<Course> getAllCourses() {
        return courserepo.findAll();
    }
    public Course getCourseById(Long id)
    {
        return courserepo.findById(id).orElse(null);
    }

}
