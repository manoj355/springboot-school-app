package com.example.school.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.school.Entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher,Long>{
    
}
