package com.geca.alumniCircle.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geca.alumniCircle.model.Alumni;

public interface AlumniRepository extends JpaRepository<Alumni, Long> {

	List<Alumni> findByActive(boolean b);
    // Custom query methods if needed
}

