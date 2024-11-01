package com.geca.alumniCircle.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.geca.alumniCircle.model.Alumni;
import com.geca.alumniCircle.service.AlumniService;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@CrossOrigin("*")
@RequestMapping("/api/alumni")
public class AlumniController {

    @Autowired
    AlumniService alumniService;
    
    @PostMapping("/register")
    public ResponseEntity<Alumni> addAlumni(@RequestBody Alumni alumni){
    	return ResponseEntity.ok(this.alumniService.addAlumni(alumni));
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<Alumni> updateAlumni(@RequestBody Alumni alumni){
    	return ResponseEntity.ok(this.alumniService.updateAlumni(alumni));
    }
    
    @PutMapping("/update")
    public ResponseEntity<Alumni> updateAlumni1(@RequestBody Alumni alumni){
    	return ResponseEntity.ok(this.alumniService.updateAlumni(alumni));
    }
    
    @DeleteMapping("delete/{id}")
	public Alumni deleteAlumni(@PathVariable("id") Long id) {
    	Alumni alumni = this.alumniService.getAlumni(id);
		this.alumniService.deleteAlumni(id);	
		return alumni;
	}
    
    
    @GetMapping("")
    public List<Alumni> getAllAlumni() {
        return this.alumniService.getAllAlumni();
    }
    
    @GetMapping("/{id}")
	public Alumni getAlumni(@PathVariable("id") Long id) {
		return this.alumniService.getAlumni(id);		
	}
    
//    Request: GET /verified?active=true
//    Request: GET /verified?active=true
    @GetMapping("/verified")
    public List<Alumni> activeAlumni(@RequestParam boolean active) {
    	return active ? alumniService.getActiveAlumni(active) : alumniService.getActiveAlumni(active);
    }
    
    
    
    
    
}
