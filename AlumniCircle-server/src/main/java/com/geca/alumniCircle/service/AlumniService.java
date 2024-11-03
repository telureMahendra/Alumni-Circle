package com.geca.alumniCircle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.geca.alumniCircle.model.Admin;
import com.geca.alumniCircle.model.Alumni;

import com.geca.alumniCircle.repository.AlumniRepository;

@Service
public class AlumniService {

	@Autowired
	private AlumniRepository alumniRepository;
	
	@Autowired
	JWTService jwtService;
	
	public Alumni loadByUsername(String username) {
		return alumniRepository.findByUsername(username);
		
	}

	public List<Alumni> getAllAlumni() {
		return alumniRepository.findAll();
	}

	public Alumni getAlumni(Long id) {
		return alumniRepository.findById(id).get();
	}

	public Alumni updateAlumni(Alumni alumni) {
		return alumniRepository.save(alumni);
	}
	
	public Alumni addAlumni(Alumni alumni) {
		alumni.setUsername(alumni.getEmail());
		return alumniRepository.save(alumni);
	}
	
	public void deleteAlumni(Long id ) {
		alumniRepository.deleteById(id);
	}

	public List<Alumni> getActiveAlumni(Boolean b) {
		if(b) {			
			return alumniRepository.findByActive(true);
		}else {
			return alumniRepository.findByActive(false);
		}
	}

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	

    

}
