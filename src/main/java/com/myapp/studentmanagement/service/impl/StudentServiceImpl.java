package com.myapp.studentmanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.studentmanagement.entity.Student;
import com.myapp.studentmanagement.repository.StudentRepository;
import com.myapp.studentmanagement.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepo;

	@Override
	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepo.save(student);
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return studentRepo.findAll();
	}

	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepo.save(student);
	}

	@Override
	public void deleteStudent(long studentId) {
		// TODO Auto-generated method stub
		studentRepo.deleteById(studentId);
	}

	@Override
	public Student getStudentById(long studentId) {
		// TODO Auto-generated method stub
		return studentRepo.findById(studentId).get();
	}

}
