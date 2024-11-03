package com.geca.alumniCircle.service;

import java.util.List;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.geca.alumniCircle.model.Admin;
import com.geca.alumniCircle.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	AdminRepository adminRepository;

//	@Autowired
//	AuthenticationManager authManager;
	
	@Autowired
	@Qualifier("customAuthManager")  // Or "authenticationManager" based on your preference
	private AuthenticationManager authManager;

	@Autowired
	JWTService jwtService;

	@Autowired
	@Qualifier("adminDetailsService")
	private UserDetailsService adminDetailsService;

	@Autowired
	@Qualifier("alumniDetailsService")
	private UserDetailsService alumniDetailsService;

	@Autowired
	@Qualifier("studentDetailsService")
	private UserDetailsService studentDetailsService;

	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
	
	

    @Autowired
    public AdminService(@Qualifier("customAuthManager") AuthenticationManager authManager) {
        this.authManager = authManager;
    }

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

	public List<Admin> getAllAdmin() {
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

//	public String verify1(Admin admin) {
//	    System.out.println("Attempting login for user: " + admin.getUsername());
//	    
//	    // Check if the admin exists
//	    Admin existingAdmin = adminRepository.findByUsername(admin.getUsername());
//	    if (existingAdmin == null) {
//	        return "User not found";
//	    }
//	    
//	    // Use the BCryptPasswordEncoder to match the raw password with the encoded password
//	    boolean isPasswordMatch = encoder.matches(admin.getPassword(), existingAdmin.getPassword());
//	    
//	    if (isPasswordMatch) {
//	        return jwtService.generateToken(existingAdmin.getUsername());
//	    } else {
//	        return "Invalid credentials";
//	    }
//	}

	public String verify(String username, String password, String userType) {
		UserDetails userDetails;

		switch (userType) {
		case "admin":
			userDetails = adminDetailsService.loadUserByUsername(username);
			break;
		case "alumni":
			userDetails = alumniDetailsService.loadUserByUsername(username);
			break;
		case "student":
			System.out.println("student switch working");
			userDetails = studentDetailsService.loadUserByUsername(username);
			System.out.println("user loaded");
			break;
		default:
			throw new UsernameNotFoundException("User type not recognized");
		}

		
	    if (userDetails != null && userDetails.getPassword().equals(password)) {
	    	System.out.println("in if condition");
	        return jwtService.generateToken(userDetails.getUsername());
	    } else {
	        return "invalid Credentials for "+ userType;
	    }
	}

}
