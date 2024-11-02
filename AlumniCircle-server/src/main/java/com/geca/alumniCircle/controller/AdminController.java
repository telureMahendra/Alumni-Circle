package com.geca.alumniCircle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geca.alumniCircle.model.Admin;
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
