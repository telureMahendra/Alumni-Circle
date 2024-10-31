package com.geca.alumniCircle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.geca.alumniCircle.model.Alumni;
import com.geca.alumniCircle.model.Student;
import com.geca.alumniCircle.repository.StudentRepository;
import com.geca.alumniCircle.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;

	@PostMapping("/register")
    public ResponseEntity<Student> addAlumni(@RequestBody Student student){
    	return ResponseEntity.ok(this.studentService.addStudent(student));
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateAlumni(@RequestBody Student student){
    	return ResponseEntity.ok(this.studentService.updateStudent(student));
    }
    
    @DeleteMapping("delete/{id}")
	public Student deleteAlumni(@PathVariable("id") Long id) {
    	Student student = this.studentService.getStudent(id);
		this.studentService.deleteStudent(id);	
		return student;
	}
    
    
    @GetMapping("")
    public List<Student> getAllstudent() {
        return this.studentService.getAllStudent();
    }
    
    @GetMapping("/{id}")
	public Student getStudent(@PathVariable("id") Long id) {
		return this.studentService.getStudent(id);		
	}
    
//    Request: GET /verified?active=true
//    Request: GET /verified?active=true
    @GetMapping("/verified")
    public List<Student> activeAlumni(@RequestParam boolean active) {
    	return active ? studentService.getActiveStudent(active) : studentService.getActiveStudent(active);
    }
    

}