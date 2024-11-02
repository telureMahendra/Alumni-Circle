package com.geca.alumniCircle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geca.alumniCircle.model.Admin;


public interface AdminRepository extends JpaRepository<Admin, Long>{

	public Admin findByUsername(String username);
}
