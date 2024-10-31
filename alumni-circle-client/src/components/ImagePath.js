import React, { useState } from 'react';

const ImagePath = () => {
  const [formData, setFormData] = useState({
    name: '',
    email: '',
    mobile: '',
    image: null,
  });
  const [message, setMessage] = useState('');

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  const handleFileChange = (e) => {
    setFormData((prevData) => ({
      ...prevData,
      image: e.target.files[0],
    }));
  };

  const generateUniqueImageName = (originalName) => {
    const timestamp = Date.now();
    const randomNum = Math.floor(Math.random() * 10000);
    const extension = originalName.split('.').pop();
    return `${timestamp}-${randomNum}.${extension}`;
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (!formData.image) {
      alert("Please upload an image.");
      return;
    }

    const uniqueImageName = generateUniqueImageName(formData.image.name);
    
    const data = new FormData();
    data.append('name', formData.name);
    data.append('email', formData.email);
    data.append('mobile', formData.mobile);
    data.append('image', formData.image, uniqueImageName);

    try {
      const response = await fetch('https://your-api-endpoint.com/upload', {
        method: 'POST',
        body: data,
      });

      if (response.ok) {
        const result = await response.json();
        setMessage('Upload successful: ' + result.message);
      } else {
        setMessage('Upload failed: ' + response.statusText);
      }
    } catch (error) {
      setMessage('Error: ' + error.message);
    }
  };

  return (
    <div>
      <h1>Upload Form</h1>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Name:</label>
          <input
            type="text"
            name="name"
            value={formData.name}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label>Email:</label>
          <input
            type="email"
            name="email"
            value={formData.email}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label>Mobile:</label>
          <input
            type="tel"
            name="mobile"
            value={formData.mobile}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label>Image:</label>
          <input
            type="file"
            accept="image/*"
            onChange={handleFileChange}
            required
          />
        </div>
        <button type="submit">Submit</button>
      </form>
      {message && <p>{message}</p>}
    </div>
  );
};

export default ImagePath;
