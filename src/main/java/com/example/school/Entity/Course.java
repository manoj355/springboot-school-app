package com.example.school.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "name shouldnot be empty")
    private String name;
    @NotBlank(message = "subject shouldnot not empty")
    private String subject;
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    @JsonManagedReference("course-student")
    private List<Student> student;

    public List<Student> getStudent() {
        return student;
    }
    public void setStudent(List<Student> student) {
        this.student = student;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public Course() {
    }
    public Course(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }
    
    
}
