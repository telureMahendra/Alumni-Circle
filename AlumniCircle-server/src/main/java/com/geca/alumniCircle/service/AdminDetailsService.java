package com.geca.alumniCircle.service;


import com.geca.alumniCircle.model.Admin;
import com.geca.alumniCircle.model.Alumni;
import com.geca.alumniCircle.repository.AdminRepository;
import com.geca.alumniCircle.repository.AlumniRepository;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Primary
public class AdminDetailsService implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;
    
    @Autowired
    @Qualifier("adminDetailsService")
    AdminDetailsService adminDetailsService;

    @Autowired
    @Qualifier("alumniDetailsService")
    AlumniDetailsService alumniDetailsService;

    @Autowired
    @Qualifier("studentDetailsService")
    StudentDetailsService studentDetailsService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByUsername(username);
        if (admin == null) {
            throw new UsernameNotFoundException("User not found");
        }
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("admin");
        
        return new org.springframework.security.core.userdetails.User(
                admin.getUsername(),
                admin.getPassword(), // Use plaintext password
                Collections.singletonList(authority) // Pass the authorities
        );
    }
}