package com.example.school.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.school.Entity.Course;

public interface CourseRepository extends JpaRepository<Course,Long>{
    
}
