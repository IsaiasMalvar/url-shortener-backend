

---

# URLess Backend: URL Shortener Service

This is the backend service for **URLess**, a web application that allows users to shorten URLs and track analytics based on the number of clicks each link receives. This backend is built with **Spring Boot**, **JWT authentication**, and **MySQL** as the database.

---

## Features

- **URL Shortening**: Convert long URLs into short, shareable links.
- **Click Tracking**: Monitor how many times a shortened URL has been accessed.
- **User Authentication**: Secure login and user management using **JWT authentication**.
- **Database Integration**: Stores URLs and user data in a **MySQL** database.
- **Spring Boot & JPA**: Uses **Spring Boot 3.4.1** and **Spring Data JPA** for smooth and scalable development.

---

## Prerequisites

Before setting up this backend, make sure you have:

1. **Java 23** installed (or update `pom.xml` if using a different version).
2. **Maven** installed for dependency management.
3. **MySQL** installed and running on your system.

---

## Installation & Setup

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/your-username/url-shortener-sb.git
cd url-shortener-sb
```

### 2️⃣ Configure the Database
Make sure you have **MySQL** running and create a new database:
```sql
CREATE DATABASE urlshortenerdb;
CREATE USER 'urluser'@'localhost' IDENTIFIED BY 'pass123';
GRANT ALL PRIVILEGES ON urlshortenerdb.* TO 'urluser'@'localhost';
FLUSH PRIVILEGES;
```
*You can customize the database name, username, and password as needed.*

### 3️⃣ Set Up Environment Variables
Before running the application, update the `application.properties` file with your custom values:

```properties
# MySQL Database Configuration
DATABASE_URL=jdbc:mysql://localhost:3306/urlshortenerdb
DATABASE_USERNAME=urluser
DATABASE_PASSWORD=pass123
DATABASE_DIALECT=org.hibernate.dialect.MySQLDialect

# JWT Authentication Configuration
JWT_SECRET=your-very-long-secret-key  # Replace this with a secure, random string
JWT_EXPIRATION=172800000  # Expiration time in milliseconds (2 days)

# Frontend URL (CORS)
FRONTEND_URL=http://localhost:5173
```
💡 *Feel free to change these values as per your security and environment setup.*

### 4️⃣ Build & Run the Application
```bash
./mvnw spring-boot:run
```
or, if you have Maven installed globally:
```bash
mvn spring-boot:run
```

Once the server starts, the API will be available at:
```
http://localhost:8080
```

---

## API Endpoints


| Method   | Endpoint                   | Description                                  | Access       |
|----------|----------------------------|----------------------------------------------|-------------|
| `POST`   | `/api/auth/public/login`   | Authenticate user and return JWT token      | Public      |
| `POST`   | `/api/auth/public/register`| Register a new user                         | Public      |
| `POST`   | `/api/urls/shorten`        | Shorten a new URL                           | Authenticated (USER) |
| `GET`    | `/api/urls/myurls`         | Get all shortened URLs for the authenticated user | Authenticated (USER) |
| `GET`    | `/api/urls/analytics/{shortUrl}` | Get analytics (click events) for a shortened URL | Authenticated (USER) |
| `GET`    | `/api/urls/totalClicks`    | Get total clicks for all URLs by date       | Authenticated (USER) |
| `GET`    | `/{shortUrl}`              | Redirect to the original URL                | Public      |  

---

## Technologies Used

| Technology      | Purpose                              |
|---------------|--------------------------------|
| **Spring Boot 3.4.1** | Backend framework for building REST APIs |
| **Spring Security** | Handles authentication and authorization |
| **JWT (JSON Web Tokens)** | Secure authentication mechanism |
| **Spring Data JPA** | Simplifies database interactions |
| **MySQL** | Stores shortened URLs and user data |
| **Lombok** | Reduces boilerplate code |
| **Maven** | Dependency and build management |

---

## Development Notes

- The backend is configured to connect with a **MySQL** database. If you prefer **PostgreSQL**, update the dependencies in `pom.xml` and modify `application.properties` accordingly.
- The JWT secret in the `application.properties` file **must** be a long, secure random string to ensure security.
- If the frontend is running on a different domain, update `FRONTEND_URL` in your configuration to allow CORS.

---


## Deployment
For production deployment, consider:

1. **Using a secure database connection** instead of a local MySQL instance.
2. **Configuring environment variables** instead of hardcoding values in `application.properties`.
3. **Using a reverse proxy** like **NGINX** to serve the frontend alongside the backend.

---


🚀 **Enjoy using URLess to simplify and track your URLs!** 🚀
