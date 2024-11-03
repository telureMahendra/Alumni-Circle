package com.geca.alumniCircle.service;


import com.geca.alumniCircle.model.Student;
import com.geca.alumniCircle.repository.StudentRepository;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class StudentDetailsService implements UserDetailsService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student = studentRepository.findByUsername(username);
        if (student == null) {
            throw new UsernameNotFoundException("User not found");
        }
      
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("student");
        
        return new org.springframework.security.core.userdetails.User(
                student.getUsername(),
                student.getPassword(), // Use plaintext password
                Collections.singletonList(authority) // Pass the authorities
        );
        
    }
}
