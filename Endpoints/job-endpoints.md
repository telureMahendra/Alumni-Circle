# Job API Endpoints

The Student API provides endpoints for managing student records, allowing for registration, updating, retrieval, deletion, and filtering of student data.

## Base URL

All endpoints are prefixed with: `http://localhost:8080/api/job`

## Endpoints

### 1. Register Student

* **Endpoint**: `POST /register`

* **Description**: Registers a new student.

* **Sample Request Body**:

### 1. Post a Job
* **Endpoint**: `POST http://localhost:8080/api/job/post`
* **Request Body**:

```json
{
    "title": "Software Engineer",
    "description": "We are looking for a passionate software engineer to join our dynamic team. The ideal candidate should have experience in full-stack development.",
    "location": "San Francisco, CA",
    "company": "Tech Innovations LLC",
    "salary": 90000.00,
    "applyLink": "https://techinnovations.com/careers/software-engineer",
    "alumni": {
        "id": 1  // Optional
    },
    "employer": {
        "id": 2  // Optional
    }
}
```

### 2. Update a Job
* **Endpoint**: `PUT http://localhost:8080/api/jobs/update`
* **Request Body**:

```json
{
    "id": 1,
    "title": "Software Engineer",
    "description": "We are looking for a passionate software engineer to join our dynamic team. The ideal candidate should have experience in full-stack development.",
    "location": "San Francisco, CA",
    "company": "Tech Innovations LLC",
    "salary": 90000.0,
    "applyLink": "https://techinnovations.com/careers/software-engineer",
    "alumni": {
        "id": 1,
        "firstName": "mahi",
        "lastName": "telure",
        "about": "software engineer",
        "email": "test@gmail.com",
        "mobileNo": "9561051485",
        "graduationYear": "2025",
        "branch": "MCA",
        "currentCompany": "google",
        "password": "12345678",
        "active": false,
        "city": "csn",
        "photo": "poto.jpg"
    },
    "employer": null
}
```

### 3. Get All Jobs
* **Endpoint**: `GET http://localhost:8080/api/jobs`
* **Description**: Retrieves a list of all job postings.

### 4. Get Specific Job by ID
* **Endpoint**: `GET http://localhost:8080/api/jobs/1`
* **Description**: Replace 1 with the job ID.

### 5. Delete a Job
* **Endpoint**: `DELETE http://localhost:8080/api/jobs/delete/1`
* **Description**: Replace 1 with the job ID.

### 6. Jobs Posted by Specific Alumni
* **Endpoint**: `GET http://localhost:8080/api/jobs/alumni/1`
* **Description**: Replace 1 with the alumni ID.

### 7. Jobs Posted by Specific Employer
* **Endpoint**: `GET http://localhost:8080/api/jobs/employer/1`
* **Description**: Replace 1 with the employer ID.

## Notes
* Ensure to handle optional fields (alumni and employer) appropriately when posting or updating jobs.
* Consider implementing error handling and validation for all inputs to enhance API reliability.