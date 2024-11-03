package com.geca.alumniCircle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geca.alumniCircle.model.Alumni;
import com.geca.alumniCircle.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	List<Student> findByActive(boolean b);

	Student findByUsername(String username);
}
