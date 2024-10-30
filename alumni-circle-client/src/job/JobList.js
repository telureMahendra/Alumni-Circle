import React, { useEffect, useState } from 'react';
import axios from 'axios';

const JobList = () => {
  const [jobs, setJobs] = useState([]);

  useEffect(() => {
    const fetchJobs = async () => {
      try {
        const response = await axios.get('http://localhost:8080/api/jobs');
        setJobs(response.data);
      } catch (error) {
        console.error('Error fetching jobs:', error);
      }
    };

    fetchJobs();
  }, []);

  return (
    <div>
      <h2>Job Listings</h2>
      <table>
        <thead>
          <tr>
            <th>Job ID</th>
            <th>Title</th>
            <th>Description</th>
            <th>Location</th>
            <th>Company</th>
            <th>Salary</th>
            <th>Published Date</th>
            <th>Last Date</th>
            <th>Apply Link</th>
          </tr>
        </thead>
        <tbody>
          {jobs.map((job) => (
            <tr key={job.id}>
              <td>{job.id}</td>
              <td>{job.title}</td>
              <td>{job.description}</td>
              <td>{job.location}</td>
              <td>{job.company}</td>
              <td>{job.salary}</td>
              <td>{new Date(job.publishedDate).toLocaleDateString()}</td>
              <td>{new Date(job.lastDate).toLocaleDateString()}</td>
              <td>
                <a href={job.applyLink} target="_blank" rel="noopener noreferrer">
                  Apply Here
                </a>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default JobList;
