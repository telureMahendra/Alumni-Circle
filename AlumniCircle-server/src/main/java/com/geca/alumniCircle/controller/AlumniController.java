package com.geca.alumniCircle.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.geca.alumniCircle.model.Alumni;
import com.geca.alumniCircle.service.AlumniService;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/alumni")
public class AlumniController {

    @Autowired
    private AlumniService alumniService;

    @GetMapping
    public List<Alumni> getAllAlumni() {
        return alumniService.getAllAlumni();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumni> getAlumniById(@PathVariable Long id) {
        return alumniService.getAlumniById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Alumni> createAlumni(
            @RequestPart("alumni") Alumni alumni,
            @RequestPart("photo") MultipartFile photo) throws IOException {
        return ResponseEntity.ok(alumniService.createAlumni(alumni, photo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alumni> updateAlumni(
            @PathVariable Long id,
            @RequestPart("alumni") Alumni alumniDetails,
            @RequestPart(value = "photo", required = false) MultipartFile photo) throws IOException {
        return ResponseEntity.ok(alumniService.updateAlumni(id, alumniDetails, photo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlumni(@PathVariable Long id) {
        alumniService.deleteAlumni(id);
        return ResponseEntity.noContent().build();
    }
}
