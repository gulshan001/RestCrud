package com.student.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.model.Student;
import com.student.service.StudentInter;

@RestController
public class Controller {
	@Autowired
	StudentInter stu;
	
	@GetMapping("/students")
	private List<Student> getStudent(){
		return this.stu.getAll();
	}
	@PostMapping("/students")
	private String saveStudent(@RequestBody Student student) throws Exception {
		return this.stu.saveStudent(student);
	}
	@GetMapping("/students/{email}")
	private Optional<Student> getStuDetail(@PathVariable String email)throws Exception{
		return this.stu.getStudent(email);
	}
	@PutMapping("/students/{id}")
	private String update(@PathVariable(value = "id") long id, @RequestBody Student student) throws Exception {
		return this.stu.updateStudent(id, student);
		
	}
	@DeleteMapping("/students/{id}")
	private String delete(@PathVariable(value = "id") long id) throws Exception {
		return this.stu.deleteStudent(id);
	}
}
