# College Management System

A Java console application that models a college environment with students, employees, teachers, courses and modules. Built using a multi-level inheritance hierarchy to demonstrate object-oriented design principles. Developed as a college project at Technological University Dublin.

---

## What it does

The app runs in the terminal and lets you manage people and courses across three menus:

### Student Menu
- Create a new student and enrol them on a course
- Edit a student's name, age or course
- Delete a student (also removes them from their course and modules)
- Print all students
- Print students filtered by course

### Employee Menu
- Create a new employee or teacher
- Edit an employee's name, age, job title or salary
- Find an employee by ID
- Delete an employee
- Print all employees
- Print all teachers (shows whether they are a course coordinator)

### Admin Menu
- Placeholder for future admin functionality

### Other
- Print everyone in the system (students, employees and teachers)

---

## Class structure

The project uses a layered inheritance hierarchy:

```
Person
├── Student          (adds course, grade, score average, current status)
└── Employee         (adds job title, salary, current employee status)
    └── Teacher      (adds modules taught, course coordinator flag)

Course              (holds modules and enrolled students)
Module              (holds enrolled students)
```

When a student is added to a course, they are automatically added to all modules within that course. Removing a student from a course removes them from all modules too.

---

## Pre-populated data

The app starts with sample data so you can test it straight away:

**Courses:**
- Computer Science (modules: Programming, Software Architecture, Web Design)
- Pre University Law (modules: Contract Law, Criminal Law, Family Law)

**Students:**
- Sam Jones — Computer Science
- Mary Adams — Computer Science
- Jim Jones — Pre University Law
- Joan Byrne — Pre University Law

**Staff:**
- Eddie Smith — Caretaker (Employee)
- Tanya Bloggs — Teacher (teaches Family Law and Criminal Law)

---

## Project structure

```
src/
├── Application.java    # Main class — all menus and logic
├── Person.java         # Base class for all people
├── Student.java        # Extends Person
├── Employee.java       # Extends Person
├── Teacher.java        # Extends Employee
├── Course.java         # Holds modules and enrolled students
└── Module.java         # Holds enrolled students
```

---

## How to run

### Requirements
- Java 8 or higher
- Any IDE (NetBeans, IntelliJ, Eclipse) or a terminal

### Steps

**In an IDE:**
1. Open the project
2. Run `Application.java` as the main class

**In a terminal:**
```bash
javac *.java
java Application
```

---

## Built with

- Java
- Object-oriented design (multi-level inheritance, polymorphism)
- Java Collections (ArrayList)
- Console I/O (Scanner, BufferedReader)

---

## Author

Seanne Oriemo  
BSc Data Science and Artificial Intelligence, TU Dublin  
[LinkedIn](https://www.linkedin.com/in/seanne-oriemo-8937b5299/) | [GitHub](https://github.com/SeanneDSAI)
