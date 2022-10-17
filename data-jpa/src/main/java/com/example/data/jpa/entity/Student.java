package com.example.data.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "student_Id")
    private Long studentId;
    @Column(name="student_firstName")
    private String firstName;
    @Column(name="student_lastName")
    private String lastName;
    @Column(name="department_Name")
    private String departmentName;
    @Column(name="email_Id")
    private String emailId;

}
