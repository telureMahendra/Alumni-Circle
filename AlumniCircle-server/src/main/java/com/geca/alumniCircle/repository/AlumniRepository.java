package com.geca.alumniCircle.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.geca.alumniCircle.model.Alumni;

public interface AlumniRepository extends JpaRepository<Alumni, Long> {
    // Custom query methods if needed
}

