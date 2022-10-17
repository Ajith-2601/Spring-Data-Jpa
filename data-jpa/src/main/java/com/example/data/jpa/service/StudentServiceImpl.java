package com.example.data.jpa.service;

import com.example.data.jpa.entity.Student;
import com.example.data.jpa.error.StudentNotFoundException;
import com.example.data.jpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
       return studentRepository.save(student);

    }

    @Override
    public Student updateStudentById(Long studentId, Student student) {
        //if you dont use optional you can use get - if u dont use get whatever Id you pass it will show whether its there in db or not
        Student studentDb = studentRepository.findById(studentId).get();

       if(Objects.nonNull(student.getFirstName())&& !"".equalsIgnoreCase(student.getFirstName()))
       {
           studentDb.setFirstName(student.getFirstName());
       }
       if(Objects.nonNull(student.getLastName())&&!"".equalsIgnoreCase(student.getLastName()))
       {
           studentDb.setLastName(student.getLastName());
       }
        if(Objects.nonNull(student.getDepartmentName())&&!"".equalsIgnoreCase(student.getDepartmentName()))
        {
            studentDb.setDepartmentName(student.getDepartmentName());
        }
        if(Objects.nonNull(student.getEmailId())&&!"".equalsIgnoreCase(student.getEmailId()))
        {
            studentDb.setEmailId(student.getEmailId());
        }
        return studentRepository.save(studentDb);
    }

    @Override
    public void deleteByFirstName(String firstName) {
         studentRepository.deleteByFirstName(firstName);
    }

    @Override
    public List<Student> getAllStudentList() {
        return studentRepository.findAll();
    }

    @Override
    public void getStudentById(Long studentId) {
        //if you dont use optional you can use get - if u dont use get whatever Id you pass it will show whether its there in db or not
        //studentRepository.findById(studentId).get();
        Optional<Student> student =studentRepository.findById(studentId);
        //If not present
        if(!student.isPresent())
        {
            throw new StudentNotFoundException("Student Not Available");
        }
        student.get();//If present

    }

    @Override
    public Student updateStudentByFirstName(String firstName,Student student) {
       Student student1 = studentRepository.findByFirstName(firstName);
       if(Objects.nonNull(student.getFirstName())&&!"".equalsIgnoreCase(student.getFirstName()))
        {
            student1.setFirstName(student.getFirstName());
        }
       if(Objects.nonNull(student.getLastName())&&!"".equalsIgnoreCase(student.getLastName()))
       {
           student1.setLastName(student.getLastName());
       }
       if(Objects.nonNull(student.getDepartmentName())&&!"".equalsIgnoreCase(student.getDepartmentName()))
       {
           student1.setDepartmentName(student.getDepartmentName());
       }
       if(Objects.nonNull(student.getEmailId())&&!"".equalsIgnoreCase(student.getEmailId()))
       {
           student1.setEmailId(student.getEmailId());
       }
       studentRepository.save(student1);
       return student1;
    }
}
