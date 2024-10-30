import React, { useState } from 'react';
import axios from 'axios';

const AlumniForm = () => {
    const [alumni, setAlumni] = useState({
        firstName: '',
        lastName: '',
        about: '',
        email: '',
        mobileNo: '',
        graduationYear: '',
        branch: '',
        currentCompany: '',
        password: '',
        city: '',
        verificationStatus: false, // Default value
    });
    const [photo, setPhoto] = useState(null);
    const [message, setMessage] = useState('');

    const handleChange = (e) => {
        const { name, value } = e.target;
        setAlumni((prev) => ({ ...prev, [name]: value }));
    };

    const handleFileChange = (e) => {
        setPhoto(e.target.files[0]);
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        const formData = new FormData();
        formData.append('alumni', new Blob([JSON.stringify(alumni)], { type: 'application/json' }));
        formData.append('photo', photo);

        try {
            const response = await axios.post('http://localhost:8080/api/alumni', formData, {
                headers: {
                    'Content-Type': 'multipart/form-data',
                },
            });
            setMessage('Alumni added successfully!');
            // Reset form
            setAlumni({
                firstName: '',
                lastName: '',
                about: '',
                email: '',
                mobileNo: '',
                graduationYear: '',
                branch: '',
                currentCompany: '',
                password: '',
                city: '',
                verificationStatus: false,
            });
            setPhoto(null);
        } catch (error) {
            console.error('There was an error!', error);
            setMessage('Error adding alumni. Please try again.');
        }
    };

    return (
        <div>
            <h2>Add Alumni</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    <label>First Name:</label>
                    <input
                        type="text"
                        name="firstName"
                        value={alumni.firstName}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div>
                    <label>Last Name:</label>
                    <input
                        type="text"
                        name="lastName"
                        value={alumni.lastName}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div>
                    <label>About:</label>
                    <textarea
                        name="about"
                        value={alumni.about}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div>
                    <label>Email:</label>
                    <input
                        type="email"
                        name="email"
                        value={alumni.email}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div>
                    <label>Mobile No:</label>
                    <input
                        type="text"
                        name="mobileNo"
                        value={alumni.mobileNo}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div>
                    <label>Graduation Year:</label>
                    <input
                        type="number"
                        name="graduationYear"
                        value={alumni.graduationYear}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div>
                    <label>Branch:</label>
                    <input
                        type="text"
                        name="branch"
                        value={alumni.branch}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div>
                    <label>Current Company:</label>
                    <input
                        type="text"
                        name="currentCompany"
                        value={alumni.currentCompany}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div>
                    <label>Password:</label>
                    <input
                        type="password"
                        name="password"
                        value={alumni.password}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div>
                    <label>City:</label>
                    <input
                        type="text"
                        name="city"
                        value={alumni.city}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div>
                    <label>Photo:</label>
                    <input
                        type="file"
                        accept="image/*"
                        onChange={handleFileChange}
                        required
                    />
                </div>
                <button type="submit">Save Alumni</button>
            </form>
            {message && <p>{message}</p>}
        </div>
    );
};

export default AlumniForm;
