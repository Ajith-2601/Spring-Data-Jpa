package com.example.data.jpa.controller;

import com.example.data.jpa.entity.Student;
import com.example.data.jpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    //Add Student Data
    @PostMapping("/saveStudent")
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    //Update Student Data by StudentId
    @PutMapping("/updateStudent/{studentId}")
    public Student updateStudentById(@PathVariable Long studentId,
                                           @RequestBody Student student)
    {
        return studentService.updateStudentById(studentId,student);

    }
    //Delete Student Data by First Name
    @DeleteMapping("/deleteStudent/{name}")
    public String deleteStudentByFirstName(@PathVariable("name") String firstName)
    {
         studentService.deleteByFirstName(firstName);
         return "Student Data Deleted!!!";
    }
    //Get All Student Data
    @GetMapping("/list")
    public List<Student> getAllStudentList()
    {
        return studentService.getAllStudentList();
    }
    //Get Student Data by StudentId
    @GetMapping("/studentById/{id}")
    public String getStudentById(@PathVariable("id")Long studentId)
    {
        studentService.getStudentById(studentId);
        return "Student by id has been fetched:" +studentId;
    }
    //Update Student by First Name
    @PutMapping("updateByFirstName/{firstName}")
    public Student updateByFirstName(@PathVariable String firstName,
                                     @RequestBody Student student)
    {
        return studentService.updateStudentByFirstName(firstName,student);

    }
}
