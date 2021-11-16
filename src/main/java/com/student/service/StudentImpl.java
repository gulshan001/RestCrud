package com.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.model.Student;
import com.student.repo.StudentRepo;

@Service
public class StudentImpl implements StudentInter{

	@Autowired
	StudentRepo repo;
	@Override
	public List<Student> getAll() {
		return this.repo.findAll();
	}

	@Override
	public String saveStudent(Student stu) throws Exception{
		String email = stu.getEmail();
		if(email!=null || email!= "") {
			Student s = repo.getByEmail(email);
			if(s!=null) throw new Exception("Stuent already register with email "+email);
		}
		 this.repo.save(stu);
		 return "Student registered sucessfully!";
	}

	@Override
	public Optional<Student> getStudent(String email) throws Exception {
		if(email!=null || email!="") {
			Student s1 = repo.getByEmail(email);
			if(s1==null) throw new Exception("There is no student registered from email: "+email);
		}
		return this.repo.findByEmail(email);
	}

	@Override
	public String updateStudent(long id, Student student) throws Exception {
		Student s = this.repo.findById(id);
		if(s==null) throw new Exception("Student not found");
		
		s.setEmail(student.getEmail());
		s.setName(student.getName());
		s.setAddress(student.getAddress());
		this.repo.save(s);
		return "Student record with email "+student.getEmail()+" is updated";
	}

	@Override
	public String deleteStudent(long id) throws Exception {
		Student s = this.repo.findById(id);
		if(s == null) throw new Exception("Student not found with id "+id);
		
		this.repo.deleteById(id);
		return "Student deleted";
	}

}
