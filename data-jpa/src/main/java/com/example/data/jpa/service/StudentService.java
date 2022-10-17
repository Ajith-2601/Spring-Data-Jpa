package com.example.data.jpa.service;

import com.example.data.jpa.entity.Student;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);


    Student updateStudentById(Long studentId, Student student);

    void deleteByFirstName(String firstName);

    List<Student> getAllStudentList();

    void getStudentById(Long studentId);

    Student updateStudentByFirstName(String firstName, Student student);
}
