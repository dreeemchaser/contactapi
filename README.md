# Contact API
 
A RESTful API for managing contacts, built with **Spring Boot 3**, **Spring Data JPA**, and **PostgreSQL**. Designed for reliability, clean architecture, and easy deployment.
 
---
 
## Table of Contents
 
- [Overview](#overview)
- [Tech Stack](#tech-stack)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Configuration](#configuration)
- [API Endpoints](#api-endpoints)
- [Project Structure](#project-structure)
- [Running Tests](#running-tests)
- [Building for Production](#building-for-production)
- [Contributing](#contributing)
- [License](#license)
 
---
 
## Overview
 
Contact API provides a clean, RESTful interface for creating, reading, updating, and deleting contact records. It follows standard REST conventions and is backed by a PostgreSQL database via Spring Data JPA.
 
---
 
## Tech Stack
 
| Layer | Technology |
|---|---|
| Language | Java 25 |
| Framework | Spring Boot 3.5.x |
| Persistence | Spring Data JPA + Hibernate |
| Database | PostgreSQL |
| Build Tool | Maven (via Maven Wrapper) |
| Boilerplate Reduction | Lombok |
| Testing | Spring Boot Test (JUnit 5) |
 
---
 
## Prerequisites
 
Before running this project, make sure you have the following installed:
 
- **Java 25+** — [Download](https://jdk.java.net/)
- **PostgreSQL** — [Download](https://www.postgresql.org/download/)
- **Maven 3.9+** *(optional — the Maven Wrapper `./mvnw` is included)*
 
---
 
## Getting Started
 
### 1. Clone the repository
 
```bash
git clone https://github.com/dreeemchaser/contactapi.git
cd contactapi
```
 
### 2. Set up the database
 
Create a PostgreSQL database for the application:
 
```sql
CREATE DATABASE contactapi;
```
 
### 3. Configure environment variables
 
Copy the example configuration and fill in your database credentials (see [Configuration](#configuration) below).
 
### 4. Run the application
 
```bash
./mvnw spring-boot:run
```
 
On Windows:
 
```bash
mvnw.cmd spring-boot:run
```
 
The API will be available at `http://localhost:8080`.
 
---
 
## Configuration
 
Set the following properties in `src/main/resources/application.properties` (or via environment variables):
 
```properties
# Server
server.port=8080
 
# Database
spring.datasource.url=jdbc:postgresql://localhost:5432/contactapi
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password
 
# JPA / Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=false
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```
 
> **Tip:** For local development, you can override any property using environment variables. For example, set `SPRING_DATASOURCE_URL` to override the datasource URL without editing the file.
 
---
 
## API Endpoints
 
Base URL: `http://localhost:8080`
 
| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/contacts` | Retrieve all contacts |
| `GET` | `/contacts/{id}` | Retrieve a contact by ID |
| `POST` | `/contacts` | Create a new contact |
| `PUT` | `/contacts/{id}` | Update an existing contact |
| `DELETE` | `/contacts/{id}` | Delete a contact |
 
### Example Request — Create Contact
 
```http
POST /contacts
Content-Type: application/json
 
{
  "name": "Jane Doe",
  "email": "jane.doe@example.com",
  "phone": "+27 21 123 4567"
}
```
 
### Example Response
 
```json
{
  "id": 1,
  "name": "Jane Doe",
  "email": "jane.doe@example.com",
  "phone": "+27 21 123 4567"
}
```
 
---
 
## Project Structure
 
```
contactapi/
├── src/
│   ├── main/
│   │   ├── java/co/draai/contactapi/
│   │   │   ├── ContactapiApplication.java   # Entry point
│   │   │   ├── controller/                  # REST controllers
│   │   │   ├── service/                     # Business logic
│   │   │   ├── repository/                  # JPA repositories
│   │   │   └── model/                       # Entity classes
│   │   └── resources/
│   │       └── application.properties       # App configuration
│   └── test/
│       └── java/co/draai/contactapi/        # Unit & integration tests
├── .mvn/wrapper/                            # Maven Wrapper config
├── pom.xml                                  # Project dependencies
├── mvnw                                     # Maven Wrapper (Unix)
└── mvnw.cmd                                 # Maven Wrapper (Windows)
```
 
---
 
## Running Tests
 
```bash
./mvnw test
```
 
Test reports are generated in `target/surefire-reports/`.
 
---
 
## Building for Production
 
Build a runnable JAR:
 
```bash
./mvnw clean package -DskipTests
```
 
The output JAR will be at `target/contactapi-0.0.1-SNAPSHOT.jar`.
 
Run it directly:
 
```bash
java -jar target/contactapi-0.0.1-SNAPSHOT.jar
```
 
You can pass configuration overrides at runtime:
 
```bash
java -jar target/contactapi-0.0.1-SNAPSHOT.jar \
  --spring.datasource.url=jdbc:postgresql://prod-host:5432/contactapi \
  --spring.datasource.username=prod_user \
  --spring.datasource.password=prod_pass
```
 
---
 
## Contributing
 
Contributions are welcome! Please follow these steps:
 
1. Fork the repository
2. Create a feature branch: `git checkout -b feature/your-feature-name`
3. Commit your changes: `git commit -m "feat: add your feature"`
4. Push to your branch: `git push origin feature/your-feature-name`
5. Open a Pull Request
 
Please follow [Conventional Commits](https://www.conventionalcommits.org/) for commit messages.
 
---
 
## License
 
This project is licensed under the [MIT License](LICENSE).
 
