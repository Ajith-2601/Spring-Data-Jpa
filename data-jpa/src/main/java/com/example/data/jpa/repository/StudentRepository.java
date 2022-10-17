package com.example.data.jpa.repository;

import com.example.data.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    @Transactional
    void deleteByFirstName(String firstName);

    Student findByFirstName(String firstName);
}
