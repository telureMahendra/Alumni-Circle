package com.geca.alumniCircle.model;


import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "employers")
public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;
    private String email;
    private String password; // Or any other relevant fields

    @OneToMany(mappedBy = "employer")
    private Set<Job> jobs;  // Relationship with Job

    // Getters and Setters
    // ...
}
