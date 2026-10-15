# AI Job Recommendation Platform

An AI-inspired Job Recommendation Platform built using **HTML, CSS, JavaScript, Java Spring Boot, and Oracle SQL / MySQL**. The platform helps users explore job opportunities, find relevant jobs based on their skills, and apply for suitable positions.

## 🚀 Features

- **Job Listings:** View available job opportunities.
- **Skill-Based Recommendations:** Get job recommendations based on skills and keywords.
- **Job Search:** Search jobs by title, skills, or location.
- **Apply for Jobs:** Submit applications for suitable jobs.
- **Career Assistant:** Get basic career-related guidance.
- **REST APIs:** Backend APIs developed using Spring Boot.
- **Database Integration:** Store job information and applications in a relational database.
- **Responsive UI:** Simple frontend built using HTML, CSS, and JavaScript.

## 🛠️ Technologies Used

**Frontend**
- HTML5
- CSS3
- JavaScript

**Backend**
- Java
- Spring Boot
- Spring Data JPA
- REST APIs
- Maven

**Database**
- Oracle Database (SQL*Plus), if configured
- MySQL, if configured

## 📁 Project Structure

```text
AI-Job-Recommendation-Platform/
├── src/
│   └── main/
│       ├── java/
│       │   └── ...
│       └── resources/
│           ├── static/
│           └── application.properties
├── pom.xml
└── README.md
```

## ⚙️ Prerequisites

Install the following before running the application:

- JDK 17 or a compatible supported JDK
- Apache Maven
- Oracle Database or MySQL
- Git
- Visual Studio Code or IntelliJ IDEA

## 🔧 Database Configuration

Configure your database connection in:

`src/main/resources/application.properties`

For Oracle Database, use the following example and replace the service name, username, and password with your own database details.

```properties
spring.datasource.url=jdbc:oracle:thin:@//localhost:1521/XEPDB1
spring.datasource.username=YOUR_ORACLE_USERNAME
spring.datasource.password=YOUR_ORACLE_PASSWORD
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.open-in-view=false
```

**Important:** The Oracle JDBC dependency must be configured in `pom.xml` before using Oracle. `XEPDB1` is only an example service name; use the service name configured on your system.

Do not upload your real database password to a public GitHub repository.

## ▶️ How to Run

### 1. Clone the Repository

```bash
git clone https://github.com/2025SHIVAM/AI-Job-Recommendation-Platform.git
```

### 2. Open the Project

```bash
cd AI-Job-Recommendation-Platform
```

### 3. Configure the Database

Update `application.properties` with your database URL, username, and password. Ensure the JDBC dependency in `pom.xml` matches your database.

### 4. Run the Application

```bash
mvn clean spring-boot:run
```

### 5. Open the Application

If the application is configured to run on port `8081`, open:

http://localhost:8081

## 🔗 Backend API

The backend exposes REST endpoints for job listings, recommendations, applications, and career assistance. Exact endpoint paths depend on the controller mappings in the source code.

## 🎯 Project Objective

The objective of this project is to demonstrate full-stack development skills by combining a web-based user interface, a Java Spring Boot backend, REST API development, and relational database integration.

## 👨‍💻 Author

**Shivam Pathak**

B.Tech in Computer Science Engineering | 2025 Graduate

**Skills:** Java, Spring Boot, REST APIs, SQL, HTML, CSS, JavaScript, and MySQL/Oracle Database.

## 📌 Disclaimer

This is an educational and portfolio project. Job recommendations are based on the application's implemented logic and should not be considered a guarantee of employment.
