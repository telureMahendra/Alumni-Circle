package com.geca.alumniCircle.service;



import com.geca.alumniCircle.model.Alumni;
import com.geca.alumniCircle.repository.AlumniRepository;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AlumniDetailsService implements UserDetailsService {

    @Autowired
    private AlumniRepository alumniRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Alumni alumni = alumniRepository.findByUsername(username);
        if (alumni == null) {
            throw new UsernameNotFoundException("User not found");
        }
        
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("admin");
        
        return new org.springframework.security.core.userdetails.User(
                alumni.getUsername(),
                alumni.getPassword(), // Use plaintext password
                Collections.singletonList(authority) // Pass the authorities
        );
    }
}
