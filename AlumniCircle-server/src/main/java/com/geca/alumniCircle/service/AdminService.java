package com.geca.alumniCircle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geca.alumniCircle.model.Admin;
import com.geca.alumniCircle.repository.AdminRepository;


@Service
public class AdminService {
	
	@Autowired
	AdminRepository adminRepository;
	
	public Admin getbyUsername(String username) {
		return adminRepository.findByUsername(username);
	}
	
	public Admin findByUsername(String username) {
		return adminRepository.findByUsername(username);
	}
	
	
	
	public Admin addAdmin(Admin admin) {
		return adminRepository.save(admin);
	}
	
	public List<Admin> getAllAdmin(){
		return adminRepository.findAll();
	}
}
