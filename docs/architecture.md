# Architecture

## Overview

The Contact API is a RESTful web service built with Spring Boot 3.5.13, Java 25, and PostgreSQL database. It follows a layered architecture pattern.

## Layers

### Presentation Layer
- REST Controllers (not implemented yet - assumed endpoints for CRUD operations on contacts)

### Service Layer
- `ContactService`: Business logic for contact management, including photo uploads.

### Repository Layer
- `ContactRepository`: JPA repository for data access, extends `JpaRepository<Contact, String>`.

### Domain Layer
- `Contact`: JPA entity representing a contact with fields like name, email, phone, etc.

## Technologies

- **Framework**: Spring Boot 3.5.13
- **Language**: Java 25
- **Database**: PostgreSQL
- **ORM**: JPA/Hibernate
- **Build Tool**: Maven
- **Utilities**: Lombok for boilerplate reduction

## Data Model

The `Contact` entity has the following attributes:
- `id`: UUID primary key
- `name`: String
- `email`: String (unique)
- `title`: String
- `phone`: String
- `address`: String
- `status`: String
- `photoURL`: String

## Configuration

Application configuration is minimal, stored in `application.properties`. Database connection details should be added for production.

## Security Considerations

- No authentication implemented yet.
- File uploads for photos stored locally - consider cloud storage for production.
- Input validation needed.

## Scalability

- Uses pagination for contact listing.
- Stateless design suitable for horizontal scaling.