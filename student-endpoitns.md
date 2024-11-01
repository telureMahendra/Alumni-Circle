\# Student API Endpoints

The Student API provides endpoints for managing student records, allowing for registration, updating, retrieval, deletion, and filtering of student data.

\## Base URL

All endpoints are prefixed with: [http://localhost:8080/api/student](http://localhost:8080/api/student)

\## Endpoints

\### 1. Register Student

\- \*\*Endpoint\*\*: \`POST /register\`

\- \*\*Description\*\*: Registers a new student.

\- \*\*Sample Request Body\*\*:

\`\`\`json

{

"firstName": "raj",

"lastName": "sharma",

"enrollmentNumber": "MC23F14F069",

"about": "An enthusiastic data analyst with a passion for interpreting data to drive business success.",

"email": "raj@sharma.com",

"mobileNo": "9876543210",

"branch": "MCA",

"graduationYear": "2025",

"password": "12346789",

"city": "delhi",

"photo": "url\_to\_photo.jpg",

"idProof": "id.jpg"

}

\`\`\`

### 2\. Update Student Details

*   **Endpoint**: PUT /update/{studentId}
    
*   **Description**: Updates details for an existing student.
    
*   **Sample Request Body**:
    

\`\`\`json{

"id": 2,

"firstName": "Mahi",

"lastName": "telure",

"enrollmentNumber": "MC23F14F062",

"about": "An enthusiastic data analyst with a passion for interpreting data to drive business success.",

"email": "mahi@telure.com",

"mobileNo": "987-654-3210",

"branch": "MCA",

"graduationYear": "2025",

"password": "12346789",

"active": true,

"city": "Los Angeles",

"photo": "url\_to\_photo.jpg",

"idProof": "id.jpg",

"role": "student"

}

\`\`\`

### 3\. Get All Students

*   **Endpoint**: GET /
    
*   **Description**: Retrieves a list of all students.
    

### 4\. Get Student by ID

*   **Endpoint**: GET /{studentId}
    
*   **Description**: Retrieves details of a specific student by their ID.
    
*   **Sample Response**:
    

\`\`\`json

{

"id": 2,

"firstName": "Mahi",

"lastName": "telure",

"enrollmentNumber": "MC23F14F062",

"about": "An enthusiastic data analyst with a passion for interpreting data to drive business success.",

"email": "mahi@telure.com",

"mobileNo": "987-654-3210",

"branch": "MCA",

"graduationYear": "2025",

"password": "12346789",

"active": true,

"city": "Los Angeles",

"photo": "url\_to\_photo.jpg",

"idProof": "id.jpg",

"role": "student"

}

\`\`\`

### 5\. Delete Student

*   **Endpoint**: DELETE /delete/{studentId}
    
*   **Description**: Deletes a specific student entry by their ID.
    

### 6\. Get Verified Students

*   **Endpoint**: GET /verified?active=true
    
*   **Description**: Retrieves a list of verified (active) students.
    

### 7\. Get Unverified Students

*   **Endpoint**: GET /verified?active=false
    
*   **Description**: Retrieves a list of unverified (inactive) students.