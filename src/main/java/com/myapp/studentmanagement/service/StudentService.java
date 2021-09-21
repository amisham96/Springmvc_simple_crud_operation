package com.myapp.studentmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myapp.studentmanagement.entity.Student;

@Service
public interface StudentService {
	Student addStudent(Student student);

	List<Student> getAllStudent();
	
	Student getStudentById(long studentId);

	Student updateStudent(Student student);

	void deleteStudent(long studentId);
}
