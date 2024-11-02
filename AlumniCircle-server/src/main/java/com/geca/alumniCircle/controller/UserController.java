package com.geca.alumniCircle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geca.alumniCircle.model.Admin;
import com.geca.alumniCircle.service.AdminService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	AdminService adminService;
	
	@GetMapping("")	
	public Admin getAdminByUsername(@PathVariable("username") String username) {
		return adminService.getbyUsername(username);
	}
	
}
