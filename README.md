
# AppAquarius - Backend

This is the backend service for **AppAquarius**, developed using [Spring Boot](https://spring.io/projects/spring-boot) and [Java 17](https://openjdk.org/projects/jdk/17/). It provides a secure RESTful API for managing employees and their assigned areas.

## 🚀 Running the Application Locally

To run the backend server locally, use the following commands:

```bash
# Compile the project
mvn clean install

# Run the application
mvn spring-boot:run
```

Once the application is running, the backend will be available at:

```
http://localhost:8080/
```

You can test the API using tools like [Postman](https://www.postman.com/) or `curl`.

## 🛠️ Database Configuration

This application uses a MySQL-compatible database. Configure your connection settings in:

```
src/main/resources/application.properties
```

Example configuration:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/aquariusdb
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

## 🗃️ Database Initialization Script

Use the following SQL script to create the `aquariusdb` database and its schema:

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
```
![image](https://github.com/user-attachments/assets/8ea2523f-785c-46c7-9d7b-38c0aca25d46)



## 🔐 Security

The backend is secured using **OAuth2** and **JWT (JSON Web Tokens)**:

- Public routes: `/api/**`
- All other routes require a valid Bearer token in the `Authorization` header.

## 📡 API Endpoints

| Method | Endpoint               | Description                |
|--------|------------------------|----------------------------|
| GET    | `/api/empleados`       | List all employees         |
| GET    | `/api/empleados/{id}`  | Get a specific employee    |
| POST   | `/api/empleados`       | Create a new employee      |
| PUT    | `/api/empleados/{id}`  | Update an existing employee|
| DELETE | `/api/empleados/{id}`  | Delete an employee         |
| GET    | `/api/areas`           | List all areas             |

## 🧱 Building the Project

To compile the project and generate a JAR file for deployment, run:

```bash
mvn clean package
```

The JAR file will be located in the `target/` directory.

To run the JAR:

```bash
java -jar target/empleado-api-0.0.1-SNAPSHOT.jar
```

## 🧪 Running Tests

Execute unit and integration tests using:

```bash
mvn test
```

## 📚 Additional Resources

- [Spring Boot Reference Documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/)
- [JWT Introduction](https://jwt.io/introduction)
- [OAuth2 Overview](https://oauth.net/2/)

---

## 📷 Project images
### Console Spring On
![image](https://github.com/user-attachments/assets/3ab96a97-8031-4ccc-9935-d9c00e888ea6)

### POST Postman to http://localhost:8080/api/auth/login to get the token
![image](https://github.com/user-attachments/assets/22667589-0e4b-42a5-be2b-3d3eb2a504b5)

### GET Postman to http://localhost:8080/api/areas with Authorization
![image](https://github.com/user-attachments/assets/88534de9-f5ca-4a3c-a792-f7cdd9b9a14f)

💻 Developed as part of the **AppAquarius** full-stack web application.
