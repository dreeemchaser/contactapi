# Deployment

## Prerequisites

- Java 25
- Maven 3.6+
- PostgreSQL 12+

## Local Development

1. Clone the repository:
   ```bash
   git clone <repo-url>
   cd contactapi
   ```

2. Set up PostgreSQL database:
   ```sql
   CREATE DATABASE contactdb;
   ```

3. Configure database connection in `application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/contactdb
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```

4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

5. Access at `http://localhost:8080`

## Production Deployment

### Using JAR

1. Build the JAR:
   ```bash
   mvn clean package
   ```

2. Run the JAR:
   ```bash
   java -jar target/contactapi-0.0.1-SNAPSHOT.jar
   ```

### Docker

Create a Dockerfile:
```dockerfile
FROM openjdk:25-jdk-slim
COPY target/contactapi-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
```

Build and run:
```bash
docker build -t contactapi .
docker run -p 8080:8080 contactapi
```

### Cloud Deployment

- **Heroku**: Use the JAR or Docker.
- **AWS Elastic Beanstalk**: Deploy JAR.
- **Azure App Service**: Use Docker or JAR.
- **Kubernetes**: Use the provided manifests (to be created).

## Environment Variables

- `SPRING_PROFILES_ACTIVE`: Set to `prod` for production.
- Database credentials via environment variables.

## Monitoring

- Spring Boot Actuator endpoints available at `/actuator/*`
- Enable health checks, metrics, etc.

## Security

- Use HTTPS in production.
- Configure CORS if needed.
- Implement authentication.