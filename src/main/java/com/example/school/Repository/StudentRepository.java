package com.example.school.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.school.Entity.Student;

public interface StudentRepository extends JpaRepository<Student ,Long>{
    
}
