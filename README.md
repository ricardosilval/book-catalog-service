# book-catalog-service

Microservice developed with Java and Spring Boot that exposes REST APIs for managing a catalog of books. The service implements CRUD operations, domain-driven design principles, exception handling, logging, and database persistence using Spring Data JPA. It is designed following clean architecture practices and can be integrated with external authentication services.
flowchart LR

Client[Client / Frontend]

Gateway[API Gateway]

Controller[BookController]

Service[BookService]

Domain[Domain Model\nBook]

RepositoryPort[BookRepository Port]

Adapter[BookRepositoryAdapter]

JPA[Spring Data JPA]

DB[(PostgreSQL\nbooks table)]

Auth[Auth Service\nJWT Validation]

Client --> Gateway
Gateway --> Controller

Controller --> Service
Service --> Domain
Service --> RepositoryPort

RepositoryPort --> Adapter
Adapter --> JPA
JPA --> DB

Gateway --> Auth
Auth --> Gateway
