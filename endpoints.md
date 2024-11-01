### 1\. **Register Alumni**

*   **Endpoint**: `POST http://localhost:8080/api/alumni/register`
    
*   **Description**: Registers a new alumni member with profile details.
    
*   **Sample Request Body**:
    

```json
{
    "firstName": "mahi",
    "lastName": "telure",
    "about": "I am a passionate coder",
    "email": "test@gmail.com",
    "mobileNo": "9561051485",
    "graduationYear": "2025",
    "branch": "MCA",
    "currentCompany": "google",
    "position": "software engineer",
    "password": "12345678",
    "city": "csn",
    "photo": "poto.jpg",
    "idProof": "id.jpg"
}


```

### 2\. **Update Alumni Details**

*   **Endpoint**: `PUT http://localhost:8080/api/alumni/update/{alumniId}`
    
*   **Description**: Updates the information of a specific alumni based on their ID.
    
*   **Sample Request Body**:
    
```json
{
    "id": 1,
    "firstName": "mahi",
    "lastName": "telure",
    "about": "I am a passionate coder",
    "email": "test@gmail.com",
    "mobileNo": "9561051485",
    "graduationYear": "2025",
    "branch": "MCA",
    "currentCompany": "google",
    "position": "software engineer",
    "password": "12345678",
    "active": false,
    "city": "csn",
    "photo": "poto.jpg",
    "idProof": "id.jpg",
    "role": "alumni"
}

```

### 3\. **Get All Alumni**

*   **Endpoint**: `GET http://localhost:8080/api/alumni/`
    
*   **Description**: Retrieves a list of all alumni members.
    

### 4\. **Get Alumni by ID**

*   **Endpoint**: `GET http://localhost:8080/api/alumni/{alumniId}`
    
*   **Description**: Retrieves details of a specific alumni based on their ID.
    

```json
{
    "id": 1,
    "firstName": "mahi",
    "lastName": "telure",
    "about": "I am a passionate coder",
    "email": "test@gmail.com",
    "mobileNo": "9561051485",
    "graduationYear": "2025",
    "branch": "MCA",
    "currentCompany": "google",
    "position": "software engineer",
    "password": "12345678",
    "active": false,
    "city": "csn",
    "photo": "poto.jpg",
    "idProof": "id.jpg",
    "role": "alumni"
}

```

### 5\. **Delete Alumni**

*   **Endpoint**: `DELETE http://localhost:8080/api/alumni/delete/{alumniId}`
    
*   **Description**: Deletes a specific alumni entry based on their ID.
    

### 6\. **Get Verified Alumni**

*   **Endpoint**: `GET http://localhost:8080/api/alumni/verified?active=true`
    
*   **Description**: Retrieves a list of verified (active) alumni.
    

### 7\. **Get Unverified Alumni**

*   **Endpoint**: `GET http://localhost:8080/api/alumni/verified?active=false`
    
*   **Description**: Retrieves a list of unverified (inactive) alumni.
