package com.geca.alumniCircle.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.geca.alumniCircle.model.Alumni;
import com.geca.alumniCircle.repository.AlumniRepository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class AlumniService {

    @Autowired
    private AlumniRepository alumniRepository;

    public List<Alumni> getAllAlumni() {
        return alumniRepository.findAll();
    }

    public Optional<Alumni> getAlumniById(Long id) {
        return alumniRepository.findById(id);
    }

    public Alumni createAlumni(Alumni alumni, MultipartFile photo) throws IOException {
        if (photo != null && !photo.isEmpty()) {
            alumni.setPhoto(photo.getBytes());
        }
        return alumniRepository.save(alumni);
    }

    public Alumni updateAlumni(Long id, Alumni alumniDetails, MultipartFile photo) throws IOException {
        Alumni alumni = alumniRepository.findById(id).orElseThrow(() -> new RuntimeException("Alumni not found"));
        alumni.setFirstName(alumniDetails.getFirstName());
        alumni.setLastName(alumniDetails.getLastName());
        alumni.setAbout(alumniDetails.getAbout());
        alumni.setEmail(alumniDetails.getEmail());
        alumni.setMobileNo(alumniDetails.getMobileNo());
        alumni.setGraduationYear(alumniDetails.getGraduationYear());
        alumni.setBranch(alumniDetails.getBranch());
        alumni.setCurrentCompany(alumniDetails.getCurrentCompany());
        alumni.setPassword(alumniDetails.getPassword());
        alumni.setVerificationStatus(alumniDetails.getVerificationStatus());
        alumni.setCity(alumniDetails.getCity());
        if (photo != null && !photo.isEmpty()) {
            alumni.setPhoto(photo.getBytes());
        }
        return alumniRepository.save(alumni);
    }

    public void deleteAlumni(Long id) {
        alumniRepository.deleteById(id);
    }
}
