package com.myapp.studentmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.myapp.studentmanagement.entity.Student;
import com.myapp.studentmanagement.service.StudentService;

@Controller
public class StudentApp {

	@Autowired
	StudentService studentService;

	@GetMapping("/")
	public String indexPage() {
		return "index";
	}

	@GetMapping("/students")
	public String lisStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudent());
		return "list_students";
	}

	@GetMapping("/students/new")
	public String addStudent(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "add_student";
	}

	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.addStudent(student);
		return "redirect:/students";
	}

	@GetMapping("/students/edit/{studentId}")
	public String editStudentForm(@PathVariable long studentId, Model model) {
		model.addAttribute("student", studentService.getStudentById(studentId));
		return "edit_student";
	}

	@PostMapping("/students/{studentId}")
	public String updateStudent(@PathVariable long studentId, @ModelAttribute("student") Student student, Model model) {
		Student presentStudent = studentService.getStudentById(studentId);

		presentStudent.setStudentId(studentId);
		presentStudent.setFirstName(student.getFirstName());
		presentStudent.setLastName(student.getLastName());
		presentStudent.setStudentEmail(student.getStudentEmail());

		studentService.updateStudent(presentStudent);
		return "redirect:/students";
	}

	@GetMapping("/students/delete/{studentId}")
	public String deleteStudent(@PathVariable Long studentId) {
		studentService.deleteStudent(studentId);
		return "redirect:/students";
	}
}
