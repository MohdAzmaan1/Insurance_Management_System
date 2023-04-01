# Insurance_Management_System
This is an insurance management platform built using Spring Boot and Java. The platform allows users to manage insurance policies, clients, and claims through a RESTful API.

Requirements
Java 11 or higher
Maven
An embedded database (e.g., H2 or Apache Derby)
Setup
Clone the repository
Build the project using Maven: mvn clean install
Run the project: mvn spring-boot:run
Usage
Authentication
The API endpoints are secured using Basic Authentication. To access the endpoints, you need to provide a username and password.

API Endpoints
The following endpoints are available:

Clients
GET /api/clients: Fetch all clients.
GET /api/clients/{id}: Fetch a specific client by ID.
POST /api/clients: Create a new client.
PUT /api/clients/{id}: Update a client's information.
DELETE /api/clients/{id}: Delete a client.
Insurance Policies
GET /api/policies: Fetch all insurance policies.
GET /api/policies/{id}: Fetch a specific insurance policy by ID.
POST /api/policies: Create a new insurance policy.
PUT /api/policies/{id}: Update an insurance policy.
DELETE /api/policies/{id}: Delete an insurance policy.
Claims
GET /api/claims: Fetch all claims.
GET /api/claims/{id}: Fetch a specific claim by ID.
POST /api/claims: Create a new claim.
PUT /api/claims/{id}: Update a claim's information.
DELETE /api/claims/{id}: Delete a claim.


