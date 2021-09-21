package com.myapp.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapp.studentmanagement.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
