import React, { useState } from 'react';
import axios from 'axios';

const PostJobForm = () => {
  const [job, setJob] = useState({
    title: '',
    description: '',
    location: '',
    company: '',
    salary: '',
    publishedDate: '',
    lastDate: '',
    applyLink: '',
    alumniId: null, // Set this based on the logged-in user's role
    employerId: null // Set this based on the logged-in user's role
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setJob({
      ...job,
      [name]: value
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('http://localhost:8080/api/jobs', job);
      console.log('Job posted successfully:', response.data);
      // Clear form or show success message
      setJob({
        title: '',
        description: '',
        location: '',
        company: '',
        salary: '',
        publishedDate: '',
        lastDate: '',
        applyLink: '',
        alumniId: null,
        employerId: null
      });
    } catch (error) {
      console.error('Error posting job:', error);
    }
  };

  return (
    <div>
      <h2>Post a Job</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Job Title:</label>
          <input
            type="text"
            name="title"
            value={job.title}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label>Description:</label>
          <textarea
            name="description"
            value={job.description}
            onChange={handleChange}
            required
          ></textarea>
        </div>
        <div>
          <label>Location:</label>
          <input
            type="text"
            name="location"
            value={job.location}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label>Company:</label>
          <input
            type="text"
            name="company"
            value={job.company}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label>Salary:</label>
          <input
            type="text"
            name="salary"
            value={job.salary}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label>Published Date:</label>
          <input
            type="date"
            name="publishedDate"
            value={job.publishedDate}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label>Last Date to Apply:</label>
          <input
            type="date"
            name="lastDate"
            value={job.lastDate}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label>Apply Link:</label>
          <input
            type="url"
            name="applyLink"
            value={job.applyLink}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <button type="submit">Post Job</button>
        </div>
      </form>
    </div>
  );
};

export default PostJobForm;
