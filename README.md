# Habit Tracker Application

A full-stack app for tracking daily habits with streaks and stats, built with Spring Boot (backend) and plain HTML/CSS/JavaScript (frontend).

---

## Features
- Add, edit, and delete habits.
- Log daily completions and track streaks (consecutive days completed).
- View stats including current streak, completion rate, total days, and completed days.
- Simple UI with plain HTML, CSS, and JavaScript, featuring a dark theme.

---

## Tech Stack
- **Backend**  
  - Spring Boot  
  - Spring Data JPA  
  - MySQL  
  - Java 17  
  - Maven  

- **Frontend**  
  - HTML  
  - CSS  
  - JavaScript  

---

## Setup

### Install Dependencies:
- Install Java 17 (Oracle JDK or OpenJDK).
- Install Maven.
- Install MySQL Community Server.

---

### Configure MySQL:
1. Start MySQL and log in:
   ```
   mysql -u root -p
   ```
2. Create the Database:
   ```
   CREATE DATABASE habittracker;
   ```
3. Exit from MySQL:
   ```
   exit
   ```

### Update Configuration
- Edit src/main/resources/application.properties and update with your MySQL credentials:
   ```
   spring.datasource.url=jdbc:mysql://localhost:3306/habit_tracker
   spring.datasource.username=root
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
   ```
- Replace your_password with your MySQL root password.

   ---
  
### Run the Application:

1. Navigate to the project folder:
  ```
  cd habit-tracker
  ```

2. Run using Maven:
  ```
   mvn spring-boot:run
  ```

3. Run using Maven:
  ```bash
   Access the app at http://localhost:8080
  ```

### Project Structure:
```
src/main/java/com/example/habittracker/
├── HabitTrackerApplication.java      
├── model/                           
│   ├── Habit.java
│   └── HabitLog.java
├── repository/                      
│   ├── HabitRepository.java
│   └── HabitLogRepository.java
├── service/                         
│   └── HabitService.java
├── controller/                    
│   └── HabitController.java
└── config/                        
    └── CorsConfig.java

src/main/resources/
├── application.properties           
└── static/
    └── index.html                  

pom.xml                            
README.md                         
.gitignore                        

```

### Screenshot of the Application
![Image](https://github.com/user-attachments/assets/e544293a-27e7-4b79-a6f6-351b9cdbfea4)

## Contributing

Contributions are welcome!

 - &copy; Avishka14
