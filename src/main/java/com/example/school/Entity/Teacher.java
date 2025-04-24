package com.example.school.Entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @NotBlank(message = "name should be blank")
    private String name;
    @NotBlank(message = "subject hosuld be blank")
    private String subject;

    @OneToMany(mappedBy = "teacher",cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonManagedReference("teacher-student")
    private List<Student> student=new ArrayList<>();
    
    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        Id = id;
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
    public Teacher() {
    }
    public Teacher(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }
    public List<Student> getStudent() {
        return student;
    }
    public void setStudent(List<Student> student) {
        this.student = student;
    }
   
    
    
}
