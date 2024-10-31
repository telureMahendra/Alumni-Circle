package com.geca.alumniCircle.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geca.alumniCircle.model.Alumni;
import com.geca.alumniCircle.model.Student;
import com.geca.alumniCircle.repository.AlumniRepository;
import com.geca.alumniCircle.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;

	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}

	public Student getStudent(Long id) {
		return studentRepository.findById(id).get();
	}
	
	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}

	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public void deleteStudent(Long id ) {
		studentRepository.deleteById(id);
	}

	public List<Student> getActiveStudent(Boolean b) {
		if(b) {			
			return studentRepository.findByActive(true);
		}else {
			return studentRepository.findByActive(false);
		}
	}


	
	
}

