package com.example.school.DTO;

import java.util.List;

import com.example.school.Entity.Student;

public class StudentPageResponse {
    private List<Student> students;
    private int size;
    private int page;
    private int totalpage;
    private int totalStudent;
    public List<Student> getStudents() {
        return students;
    }
    public void setStudents(List<Student> students) {
        this.students = students;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public int getTotalpage() {
        return totalpage;
    }
    public void setTotalpage(int totalpage) {
        this.totalpage = totalpage;
    }
    public int getTotalStudent() {
        return totalStudent;
    }
    public void setTotalStudent(int totalStudent) {
        this.totalStudent = totalStudent;
    }
    public StudentPageResponse() {
    }
    public StudentPageResponse(List<Student> students, int size, int page, int totalpage, int totalStudent) {
        this.students = students;
        this.size = size;
        this.page = page;
        this.totalpage = totalpage;
        this.totalStudent = totalStudent;
    }
    
     
}
