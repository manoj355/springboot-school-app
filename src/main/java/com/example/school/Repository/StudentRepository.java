package com.example.school.Repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.school.Entity.Student;

public interface StudentRepository extends JpaRepository<Student ,Long>{
    Page<Student> findByLocation(String location,Pageable pageable);
    
}
