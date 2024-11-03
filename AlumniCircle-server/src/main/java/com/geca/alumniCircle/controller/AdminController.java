package com.geca.alumniCircle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geca.alumniCircle.model.Admin;
import com.geca.alumniCircle.model.Login;
import com.geca.alumniCircle.service.AdminService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@CrossOrigin("*")
@RequestMapping("/api/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
    @PostMapping("/login")
    public String login(@RequestBody Login login) {
    	Admin admin = adminService.findByUsername(login.getUsername());
    	System.out.println(adminService.verify(admin));
        return "hey";
    }
	
    @PostMapping("/login1")
    public String login1(@RequestBody Login login) {
        System.out.println("Attempting login for user: " + login.getUsername());
        Admin admin = adminService.findByUsername(login.getUsername());
        if (admin == null) {
            System.out.println("User not found.");
            return "Invalid username or password"; // Handle the case where the user is not found
        }
        String result = adminService.verify(admin);
        System.out.println("Verification result: " + result);
        return result;
    }
    
	@GetMapping("")
	public List<Admin> getAdmins() {
		return adminService.getAllAdmin();
	}
	
	@GetMapping("/{username}")
	public Admin getMethodName(@PathVariable String usename) {
		return adminService.getbyUsername(usename);
	}
	
	@PostMapping("/add")
	public Admin postMethodName(@RequestBody Admin admin) {
		return adminService.addAdmin(admin);
	}
	
	
	
	
}
