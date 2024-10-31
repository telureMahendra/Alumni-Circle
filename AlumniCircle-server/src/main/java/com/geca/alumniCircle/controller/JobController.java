package com.geca.alumniCircle.controller;

import com.geca.alumniCircle.model.Job;
import com.geca.alumniCircle.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }
    
    @GetMapping("/{id}")
    public Optional<Job> getJob(@PathVariable Long id) {
        return jobService.getJob(id);
    }

    @PostMapping("/post")
    public ResponseEntity<Job> createJob(@RequestBody Job job) {
        Job createdJob = jobService.createJob(job);
        return ResponseEntity.status(201).body(createdJob);
    }
    
    @PutMapping("/update")
    public ResponseEntity<Job> updateJob(@RequestBody Job job) {
        Job createdJob = jobService.createJob(job);
        return ResponseEntity.status(201).body(createdJob);
    }
    
    @DeleteMapping("/delete/{id}")
    public Optional<Job> deleteJob(@PathVariable Long id) {
    	Optional<Job> job = jobService.getJob(id);
    	jobService.deleteJob(id);
		return job;
    }

    @GetMapping("/alumni/{alumniId}")
    public ResponseEntity<List<Job>> getJobsByAlumniId(@PathVariable Long alumniId) {
        List<Job> jobs = jobService.getJobsByAlumniId(alumniId);
        return ResponseEntity.ok(jobs);
    }

    @GetMapping("/employer/{employerId}") // Add this new endpoint
    public ResponseEntity<List<Job>> getJobsByEmployerId(@PathVariable Long employerId) {
        List<Job> jobs = jobService.getJobsByEmployerId(employerId);
        return ResponseEntity.ok(jobs);
    }
}
