# Development Guide

## Setup

1. Install Java 25 and Maven.
2. Clone the repository.
3. Run `mvn clean install` to build.

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── contactapi/
│   │       ├── Application.java          # Main application class
│   │       ├── constant/                 # Constants
│   │       ├── domain/                   # JPA entities
│   │       ├── repository/               # Data access layer
│   │       └── service/                  # Business logic
│   └── resources/
│       ├── application.properties        # Configuration
│       ├── static/                      # Static resources
│       └── templates/                   # Thymeleaf templates (if used)
└── test/
    └── java/
        └── contactapi/
            └── ContactapiApplicationTests.java  # Tests
```

## Adding Features

1. **New Entity**: Create in `domain/`, add repository in `repository/`, service in `service/`.
2. **New Endpoint**: Create REST controller in `controller/` package (to be added).
3. **Validation**: Use Bean Validation annotations on entities.
4. **Testing**: Write unit tests in `test/` directory.

## Code Style

- Use Lombok for boilerplate.
- Follow Spring Boot conventions.
- Use meaningful variable names.
- Add JavaDoc comments.

## Testing

Run tests:
```bash
mvn test
```

## Building

```bash
mvn clean package
```

## Contributing

1. Create a feature branch.
2. Write tests.
3. Ensure code compiles.
4. Submit pull request.