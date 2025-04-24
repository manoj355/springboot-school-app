package com.example.school.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;


@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @NotBlank(message = "name should be not null")
    private String name;
    @NotBlank(message = "location should be not null")
    private String location;
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    @JsonBackReference("teacher-student")
    private Teacher teacher;
    @ManyToOne
    @JoinColumn(name = "course_id")
    @JsonBackReference("course-student")
    private Course course;

    
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
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public Student() {
    }
    public Student(@NotBlank(message = "name should be not null") String name,
            @NotBlank(message = "name should be not null") String location) {
        this.name = name;
        this.location = location;
    }
    public Teacher getTeacher() {
        return teacher;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
   
    
    
}
