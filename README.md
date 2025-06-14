# AppAquarius - Backend

This project was built using [Spring Boot](https://spring.io/projects/spring-boot) and [Java 17](https://openjdk.org/projects/jdk/17/).

## Running the application locally

To start the backend server locally, run the following commands:

```bash
# Compile the project
mvn clean install

# Run the application
mvn spring-boot:run
```

Once the server is running, the API will be available at:

http://localhost:8080/

You can use tools like Postman or curl to test the API endpoints.

## Database configuration

The application uses a MySQL (or compatible) database. Configure your connection settings in:

src/main/resources/application.properties

Example:

spring.datasource.url=jdbc:mysql://localhost:3306/aquariusdb
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update

## Script for creating the `aquariusdb` database

Below is the script to create the `aquariusdb` database and its tables:

```sql
CREATE DATABASE IF NOT EXISTS aquariusdb;
USE aquariusdb;

CREATE TABLE area (
  codigo INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL
);

CREATE TABLE empleado (
  codigo INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  correo VARCHAR(100),
  celular VARCHAR(15),
  telefono VARCHAR(15),
  area_codigo INT,
  FOREIGN KEY (area_codigo) REFERENCES area(codigo)
);

## Security

This backend uses OAuth2 and JWT for authentication.

- Public routes: /api/**
- Secured routes require a valid token.

## API endpoints

Here are some core endpoints:

| Method | Endpoint               | Description              |
|--------|------------------------|--------------------------|
| GET    | /api/empleados         | List all employees       |
| GET    | /api/empleados/{id}    | Get a specific employee  |
| POST   | /api/empleados         | Create a new employee    |
| PUT    | /api/empleados/{id}    | Update employee          |
| DELETE | /api/empleados/{id}    | Delete employee          |
| GET    | /api/areas             | List all areas           |

## Building the project

To generate the JAR file for deployment, run:

```bash
mvn clean package
```

The JAR file will be located in the `target/` directory.

To run the JAR:

```bash
java -jar target/empleado-api-0.0.1-SNAPSHOT.jar
```

## Testing

You can run unit and integration tests using:

```bash
mvn test
```

## Additional Resources

- Spring Boot Documentation: https://docs.spring.io/spring-boot/docs/current/reference/html/
- JWT Introduction: https://jwt.io/introduction
- OAuth2 Overview: https://oauth.net/2/

---

Developed as part of the AppAquarius full-stack system.
