package com.student.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long>{

	Student getByEmail(String email);
	Student findById(long id);
	Optional<Student> findByEmail(String email);

}
