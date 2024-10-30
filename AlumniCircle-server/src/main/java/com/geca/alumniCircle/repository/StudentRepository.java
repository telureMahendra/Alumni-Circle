package com.geca.alumniCircle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geca.alumniCircle.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
