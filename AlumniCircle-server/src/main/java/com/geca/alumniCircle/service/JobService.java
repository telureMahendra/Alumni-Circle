
package com.geca.alumniCircle.service;

import com.geca.alumniCircle.model.Job;
import com.geca.alumniCircle.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    public List<Job> getJobsByAlumniId(Long alumniId) {
        return jobRepository.findByAlumniId(alumniId);
    }

    public List<Job> getJobsByEmployerId(Long employerId) { // Add this method
        return jobRepository.findByEmployerId(employerId);
    }
}
