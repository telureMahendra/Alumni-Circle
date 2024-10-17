# Alumni Circle

Alumni Circle is a comprehensive Alumni Association platform designed to foster engagement between alumni, students, employers, and the college administration. It allows alumni to register, donate, engage in forums, provide feedback, manage events, and apply for jobs through a streamlined platform.

## Table of Contents
- [Features](#features)
- [Technology Stack](#technology-stack)
- [Database Design](#database-design)
- [Diagrams](#diagrams)
- [Setup Instructions](#setup-instructions)
- [Project Structure](#project-structure)
- [API Endpoints](#api-endpoints)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Features

1. **Alumni Registration**: Alumni can register by providing necessary details and create profiles that track their career progress.
2. **Donation Portal**: A streamlined donation system for alumni to contribute towards college activities and events.
3. **Event Management**: Allows administrators to create, update, and manage college events, and users can register for events.
4. **Forum Discussions**: A platform for alumni and students to discuss various topics and share knowledge, with moderation by admins.
5. **Job Portal**: Employers can post jobs and alumni can apply for job opportunities directly, providing a seamless connection between job seekers and providers.
6. **Feedback Collection**: Alumni and students can provide feedback on various aspects of the college or events, with administrative review options.
7. **Admin Portal**: Manage alumni registration, donations, events, and monitor the forum discussions, making it easy for college admins to keep track of the platform.

## Technology Stack

- **Frontend**: React.js for building a responsive and interactive user interface.
- **Backend**: Spring Boot for creating RESTful APIs and handling business logic.
- **Database**: MySQL for storing alumni, events, donations, feedback, jobs, and other platform data.
- **Other Tools**:
  - **JWT (JSON Web Token)**: For secure authentication and authorization.
  - **Spring Security**: For user role-based access control (admin, alumni, student, employer).
  - **REST APIs**: For client-server communication.
  - **MySQL**: For structured data management and persistence.

## Database Design

The platform uses MySQL for its relational database, with tables representing entities like:

- **Alumni**: Manages alumni data such as personal information, career history, and contributions.
- **Donations**: Handles alumni donations, including payment details, status, and receipts.
- **Events**: Stores event details and registrations, linking alumni and student participation.
- **Jobs**: Manages job postings and applications.
- **Feedback**: Collects feedback from alumni and students on various topics.

## Diagrams

### Flowchart 

![Flowchart ](resources/flowchart.png)

### Flowchart - Level 0

![Flowchart Level 0](resources/DFD_level_0.png)

### Flowchart - Level 1

![Flowchart Level 1](resources/DFD_level_1.png)

### Dataflow Diagram - Level 2

![Dataflow Level 2](resources/DFD_level_2.png)

### Flowchart - Level 3

![Flowchart Level 3](resources/DFD_level_3.png)

### Detailed Flowchart - Level 4

![Dataflow Level 4](/resources/DFD_level_4.png)

### Sequence 

![Sequence](/resources/Sequence.png)


## Setup Instructions

### Running the Application

### Steps

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/alumni-circle.git
   cd alumni-circle
2. **Frontend: Navigate to the frontend directory and install dependencies**:
        ```bash
        cd frontend
        npm install
        npm start
    Access the frontend at `http://localhost:3000`.
  
3. **Backend: Navigate to the backend directory and run the Spring Boot application**:
        ```bash
        cd backend
        mvn spring-boot:run
    
    The backend will run on `http://localhost:8080`.
  
4. **MySQL Setup**:
  - Create a new database.
    ```bash
    CREATE DATABASE alumni_circle;
  - Ensure the backend connects to the correct MySQL database by configuring `application.properties` in the backend folder:
    ```bash
    spring.datasource.url=jdbc:mysql://localhost:3306/alumni_circle
    spring.datasource.username=root
    spring.datasource.password=yourpassword
5. **Connecting Frontend and Backend: Ensure the API base URL in the frontend matches the running backend**:
   - Open `frontend/.env`
   - Set the backend API URL
     ```bash
     REACT_APP_API_URL=http://localhost:8080


## Project Structure
    ```plaintext
    alumni-circle/
    ├── frontend/
    │   ├── public/
    │   ├── src/
    │   │   ├── components/
    │   │   ├── pages/
    │   │   ├── services/
    │   ├── package.json
    │   ├── .env
    │   └── README.md
    ├── backend/
    │   ├── src/
    │   │   ├── main/
    │   │   ├── test/
    │   ├── pom.xml
    │   ├── application.properties
    │   └── README.md
    └── README.md

### Key Folders and Files:

- **frontend/src/components/**: Reusable components like forms, buttons, input fields, etc.
- **frontend/src/pages/**: Pages such as login, alumni registration, forum, event management, etc.
- **frontend/src/services/**: API calls for connecting the frontend to the backend.
- **backend/src/main/**: Contains backend services, controllers, and repository code.
- **application.properties**: Backend configuration (e.g., database credentials).
- **pom.xml**: Project dependencies for Spring Boot.

## API Endpoints

### Authentication
- `POST /api/auth/login`: Login a user (alumni, admin, employer, student).
- `POST /api/auth/register`: Register a new user.

### Alumni
- `GET /api/alumni/{id}`: Get details of a specific alumni.
- `POST /api/alumni/update`: Update alumni profile.

### Donation
- `POST /api/donations/submit`: Submit a new donation.
- `GET /api/donations/{id}`: Get donation details.

### Events
- `POST /api/events/create`: Create a new event.
- `GET /api/events`: Get list of all events.

### Forum
- `POST /api/forum/post`: Post a new topic or comment in the forum.
- `GET /api/forum/topics`: Get all forum topics.

### Job Management
- `POST /api/jobs/post`: Post a new job.
- `GET /api/jobs`: Get available job listings.

## Usage

## Contributing
  If you'd like to contribute to this project, you can follow these steps:
  1. Fork the repository.
  2. Create a new feature branch:
     ```bash
     git checkout -b feature/new-feature
  3. Make your changes and commit:
     ```bash
     git commit -m 'Add new feature'
  4. Push to your branch:
     ```bash
     git push origin feature/new-feature
  5. Open a pull request to merge your changes into the main branch.

## License
This project is licensed under the MIT License. See the LICENSE file for details.
    ```bash
    You can copy-paste this code into your `README.md` file for your project. This provides a comprehensive description, setup guide, and project structure along with instructions for contributing.```


