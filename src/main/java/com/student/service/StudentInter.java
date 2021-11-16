package com.student.service;

import java.util.List;
import java.util.Optional;

import com.student.model.Student;


public interface StudentInter {
	public List<Student> getAll();
	public String saveStudent(Student stu) throws Exception;
	public Optional<Student> getStudent(String email) throws Exception;
	public String updateStudent(long id, Student student) throws Exception;
	public String deleteStudent(long id) throws Exception;
}
