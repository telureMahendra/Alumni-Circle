package com.geca.alumniCircle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geca.alumniCircle.model.Job;

public interface JobRepository extends JpaRepository<Job, Long>{
	List<Job> findByAlumniId(Long alumniId);
    List<Job> findByEmployerId(Long employerId);

}
