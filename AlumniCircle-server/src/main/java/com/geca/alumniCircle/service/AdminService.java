package com.geca.alumniCircle.service;

import java.util.List;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.geca.alumniCircle.model.Admin;
import com.geca.alumniCircle.repository.AdminRepository;


@Service
public class AdminService {
	
	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
    AuthenticationManager authManager;
	
	@Autowired
	JWTService jwtService;
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
	
	public Admin getbyUsername(String username) {
		return adminRepository.findByUsername(username);
	}
	
	public Admin findByUsername(String username) {
		return adminRepository.findByUsername(username);
	}
	
	
	
	public Admin addAdmin(Admin admin) {
//		user.setPassword(encoder.encode(user.getPassword()));
//		admin.setPassword(encoder.encode(admin.getPassword()));
		return adminRepository.save(admin);
	}
	
	public List<Admin> getAllAdmin(){
		return adminRepository.findAll();
	}
	
	
	public String verify(Admin admin) {
	    System.out.println("service class " + admin);
	    // Fetch the stored admin to compare passwords
	    Admin storedAdmin = adminRepository.findByUsername(admin.getUsername());
	    if (storedAdmin != null && storedAdmin.getPassword().equals(admin.getPassword())) {
	        return jwtService.generateToken(admin.getUsername());
	    } else {
	        return "fail";
	    }
	}

	
	
	public String verify1(Admin admin) {
	    System.out.println("Attempting login for user: " + admin.getUsername());
	    
	    // Check if the admin exists
	    Admin existingAdmin = adminRepository.findByUsername(admin.getUsername());
	    if (existingAdmin == null) {
	        return "User not found";
	    }
	    
	    // Use the BCryptPasswordEncoder to match the raw password with the encoded password
	    boolean isPasswordMatch = encoder.matches(admin.getPassword(), existingAdmin.getPassword());
	    
	    if (isPasswordMatch) {
	        return jwtService.generateToken(existingAdmin.getUsername());
	    } else {
	        return "Invalid credentials";
	    }
	}

	
	
}
