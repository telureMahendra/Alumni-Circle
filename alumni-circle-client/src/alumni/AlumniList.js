import React, { useEffect, useState } from 'react';
import axios from 'axios';

const AlumniList = () => {
    const [alumni, setAlumni] = useState([]);
    const [error, setError] = useState('');

    useEffect(() => {
        const fetchAlumni = async () => {
            try {
                const response = await axios.get('http://localhost:8080/api/alumni');
                setAlumni(response.data);
            } catch (err) {
                console.error('Error fetching alumni data', err);
                setError('Could not fetch alumni data.');
            }
        };

        fetchAlumni();
    }, []);

    return (
        <div>
            <h2>Alumni List</h2>
            {error && <p>{error}</p>}
            {alumni.length > 0 ? (
                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Email</th>
                            <th>Mobile No</th>
                            <th>Branch</th>
                            <th>Current Company</th>
                            <th>Graduation Year</th>
                            <th>City</th>
                            <th>About</th>
                            <th>Photo</th>
                        </tr>
                    </thead>
                    <tbody>
                        {alumni.map((alumnus) => (
                            <tr key={alumnus.id}>
                                <td>{alumnus.id}</td>
                                <td>{alumnus.firstName}</td>
                                <td>{alumnus.lastName}</td>
                                <td>{alumnus.email}</td>
                                <td>{alumnus.mobileNo}</td>
                                <td>{alumnus.branch}</td>
                                <td>{alumnus.currentCompany}</td>
                                <td>{alumnus.graduationYear}</td>
                                <td>{alumnus.city}</td>
                                <td>{alumnus.about}</td>
                                <td>
                                    <img 
                                        src={`data:image/jpeg;base64,${alumnus.photo}`} 
                                        alt={`${alumnus.firstName} ${alumnus.lastName}`} 
                                        style={{ width: '50px', height: 'auto' }} 
                                    />
                                </td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            ) : (
                <p>No alumni found.</p>
            )}
        </div>
    );
};

export default AlumniList;
