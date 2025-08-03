# 📚 LiterAlura

**LiterAlura** is a study project where the main goal is to build a book catalog that consumes data from a public API, stores this data in a database, and allows users to interact with it via the console. This project is part of a programming challenge that focuses on key practices such as API consumption, JSON manipulation, data persistence, and user interaction through text-based menus.

## 🚀 Objective

Develop a Java application that:
- Makes HTTP requests to a book API;
- Parses and handles JSON data;
- Stores the data in a relational database;
- Offers a console interface with at least 5 interaction options.

---

## 🛠️ Technologies Used

- **Java 17+**
- **Spring Boot / JPA / Hibernate**
- **PostgreSQL Database**
- **Jackson (for JSON parsing)**
- **JDBC / Spring Data JPA**
- **IntelliJ IDEA or Eclipse**
- **Maven or Gradle**

---

## 🧩 System Features

The application provides a console-based interface with at least the following 5 options:

1. 🔍 **Search book by title**  
2. 📖 **List all registered books**  
3. ✍️ **List all registered authors**  
4. 🌐 **List books by language**  
5. 🎯 **Filter books by minimum number of downloads**

---

## 🔄 Development Steps

1. **Java Environment Setup**  
   Install JDK, configure your IDE and build system (Maven/Gradle).

2. **Project Creation**  
   Initial setup with packages for `model`, `repository`, `service`, and `main` class.

3. **API Consumption**  
   Send HTTP requests to the public book API (https://gutendex.com/books/) using title as a search parameter.

4. **JSON Response Parsing**  
   Deserialize the received data into Java classes using Jackson.

5. **Database Insertion**  
   Save books and authors using Spring Data JPA and PostgreSQL.

6. **Data Querying and Display**  
   Allow the user to search and view stored information through the console menu.

---

## ✅ Requirements

- Java 17 or higher
- Local PostgreSQL database configured
- Java-compatible IDE
- Maven or Gradle

---

## 📌 API Used

[Gutendex API](https://gutendex.com/)  
The API provides free book data including title, author, languages, and download count.

---

## 📚 Learning Outcomes

Through the development of this project, the following skills were practiced:

- REST API integration in Java;
- JSON data parsing and handling;
- Data modeling and persistence with JPA and Hibernate;
- Creating a text-based user interface with a console menu.

---

## 🧑‍💻 Author

Developed as part of a learning challenge from the Alura platform.  
Ideal for practicing system integration, programming logic, and data persistence using Java.
