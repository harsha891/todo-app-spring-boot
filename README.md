# ToDo Application

This project is a simple ToDo application built with **Spring Boot** for the backend The application allows users to create, update, delete, and retrieve tasks.

## Features

- **CRUD Operations**:
  - Create a new task.
  - Retrieve all tasks or a specific task by ID.
  - Update an existing task.
  - Delete a task.
- **Exception Handling**:
  - Custom exceptions and global exception handling for better error management.
- **Validation**:
  - Input validation to ensure correct data is provided.

## Technologies Used

### Backend
- **Java**
- **Spring Boot**
- **Spring Data JPA**
- **MySQL** (or any other relational database)
- **Maven**

  ## API Endpoints

### Tasks Controller

- `GET /api/tasks/getAllTasks`
  - Retrieve all tasks.
- `POST /api/tasks/createTask`
  - Create a new task.
- `PUT /api/tasks/updateTask/{id}`
  - Update an existing task by ID.
- `DELETE /api/tasks/deleteTask/{id}`
  - Delete a task by ID.
- `GET /api/tasks/getTaskById/{id}`
  - Retrieve a task by ID.
