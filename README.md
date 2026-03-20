_   _                            ____                      _ 
 | | | | ___  _ __ _ __ ___  _ __ |  _ \ _____   _(_) _____      _ __ 
 | |_| |/ _ \| '__| '__/ _ \| '__|| |_) / _ \ \ / / |/ _ \ \ /\ / / '__|
 |  _  | (_) | |  | | | (_) | |   |  _ <  __/\ V /| |  __/\ V  V /| |   
 |_| |_|\___/|_|  |_|  \___/|_|   |_| \_\___| \_/ |_|\___| \_/\_/ |_|   
                                                                        
   - B A C K E N D   E V O L U T I O N -

A specialized RESTful API ecosystem for Horror Cinema enthusiasts. This project manages a database of legendary horror directors, cult classics, and user reviews, evolving from a simple CRUD to a secure, production-ready backend.

🛠 Tech Stack

    Language: Java 25

    Framework: Spring Boot 3.x

    Database: PostgreSQL

    Security: Spring Security & JWT

    Tools: Maven, Hibernate (JPA), Postman, Linux (Ubuntu environment).

📌 Roadmap & Versions
📂 v1.0.0 | Foundation (Basic CRUD)

Focus: Database design and basic REST operations.

    Entity Mapping: Implementation of @Entity and @Table for Movie, Review, Director, and User.

    Relationships: Management of @OneToMany and @ManyToOne associations.

    Persistence: Use of JpaRepository for standard database operations.

    Recursive Handling: Initial use of @JsonIgnoreProperties to prevent infinite JSON loops.

📂 v2.0.0 | Refactoring (Robustness & DTOs)

Focus: Software architecture patterns and error handling.

    DTO Pattern: Decoupling the Database Layer from the Presentation Layer using Data Transfer Objects.

    Global Exception Handling: Implementation of @RestControllerAdvice to handle 404 Not Found, 400 Bad Request, and custom business exceptions.

    Data Validation: Integration of Spring Boot Starter Validation (@Valid, @NotNull, @Size) to ensure data integrity.

    Business Logic: Moving logic from Controllers to @Service classes for better maintainability.

📂 v3.0.0 | Production-Ready (Security)

Focus: Protecting resources and user authentication.

    Spring Security: Custom security configurations to protect specific endpoints.

    Authentication (JWT): Stateless authentication using JSON Web Tokens.

    RBAC (Role-Based Access Control): Implementation of ADMIN and USER roles to restrict access to sensitive operations (e.g., only Admins can delete movies).

    Password Hashing: Secure storage of user credentials using BCryptPasswordEncoder.
