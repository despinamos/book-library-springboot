# Book Library API

A RESTful backend application for managing a library.

This project is being developed as a learning project using **Java, Spring Boot, Spring Data JPA, and PostgreSQL**. The goal is to build a clean REST API while practicing common backend concepts such as DTOs, validation, exception handling, database persistence, and RESTful API design.

## 🚀 Technologies

* Java 17
* Spring Boot
* Spring Web
* Spring Data JPA
* PostgreSQL
* Maven
* Lombok
* Jakarta Bean Validation

## 📁 Project Structure

```text
src/main/java/com/demo/library_app
│
├── controller
│   └── BookController.java
│
├── core
│   ├── exception
│       ├── EntityGenericException.java
│       ├── EntityNotFoundException.java
│       └── GlobalExceptionHandler.java
│
├── dto
│   ├── BookInsertDTO.java
│   ├── BookReadOnlyDTO.java
│   └── BookPatchDTO.java
│ 
├── mapper
│   ├── Mapper.java
│
├── model
│   ├── AbstractEntity.java
│   └── Book.java
│
├── repository
│   └── BookRepository.java
│
└── service
    └── BookService.java
```

## 📚 Features

The API currently supports:

* Create a book
* Retrieve all books
* Retrieve a book by ID
* Update a book using PATCH
* Delete a book
* Check for existing books by ISBN
* Validation of incoming data
* Custom exception handling
* Automatic creation/update timestamps
* PostgreSQL persistence

More features will be added as development continues.

## 🔌 API Endpoints

### Get all books

```http
GET /api/books
```
Returns all books in the library.

### Get book by ID

```http
GET /api/books/{id}
```
Returns a books in the library by its ID.

### Create a book

```http
POST /api/books
```
Creates a new book in the library.

Example request:

```json
{
  "title": "The Hobbit",
  "author": "J.R.R. Tolkien",
  "isbn": "9780261102217",
  "genre": "Fantasy",
  "publishedYear": 1937,
  "available": true
}
```

### Patch a book

```http
PATCH /api/books/{id}
```
Updates a book (only fields specified in the request body are updated).

Example request:

```json
{
  "title": "Hobbit",
  "available": false
}
```

### Delete a book

```http
DELETE /api/books/{id}
```
Deletes a book specified by the id.

## 🗄️ Database

The application uses **PostgreSQL** for data persistence.

Required environment variables:

```text
DB_USERNAME=your_database_username
DB_PASSWORD=your_database_password
```

## ✅ Validation

The application uses Jakarta Bean Validation for validating incoming requests.

For example:

* Book title cannot be null
* Book title must contain at least 2 characters
* Author cannot be null
* Author must contain at least 2 characters

Invalid requests return an appropriate HTTP error response.

## ⚠️ Exception Handling

The application uses custom exceptions based on a generic entity exception:

```text
EntityGenericException
        ↑
        |
EntityNotFoundException
```

For example, requesting a book that does not exist results in a `404 Not Found` response.

## 🕒 Auditing

Entities inherit common timestamp fields from `AbstractEntity`:

```text
createdAt
updatedAt
```

Spring Data JPA auditing automatically manages these fields.

## 🛠️ Getting Started

### Prerequisites

Before running the application, make sure you have:

* Java 17 or later
* Maven
* PostgreSQL
* An IDE such as IntelliJ IDEA

### 1. Clone the repository

```bash
git clone <repository-url>
```

### 2. Create the database

Create a PostgreSQL database named:

```text
book_library
```

### 3. Configure environment variables

Set:

```text
DB_USERNAME
DB_PASSWORD
```

with your PostgreSQL credentials.

### 4. Run the application

Using Maven:

```bash
./mvnw spring-boot:run
```

On Windows:

```bash
mvnw.cmd spring-boot:run
```

Or run the main Spring Boot application class from your IDE.