# Insurance_Management_System
This is an insurance management platform built using Spring Boot and Java. The platform allows users to manage insurance policies, clients, and claims through a RESTful API.


# Design of the Application


# Requirements and Technology used
* Java 11 or higher
* Spring Boot 2.7.10
* Spring Data JPA
* Maven
* Apache Derby Database    
 
Note: Derby is used as an in-memory database

# Setup
* Clone the repository
* Open the project in an IDE
* Build the project using Maven: mvn clean install
* Run the project
<!-- # Usage
Authentication
The API endpoints are secured using Basic Authentication. To access the endpoints, you need to provide a username and password. -->

# API Endpoints
The following endpoints are available:

# Clients
* GET /api/clients: Fetch all clients.  
(When new client is added in database then initially, list of policy issued will be empty because no policy is issued.)
![image](https://user-images.githubusercontent.com/116377954/229309859-3375a04e-24f9-4851-8a1a-110034dcda92.png)  


* GET /api/clients/{id}: Fetch a specific client by ID.
![image](https://user-images.githubusercontent.com/116377954/229309876-a5053855-7ac3-4c20-93d5-d895bfae55d7.png)  


* POST /api/clients: Create a new client.
![image](https://user-images.githubusercontent.com/116377954/229308007-bda70e7c-8630-40c7-846b-fc604f3f0414.png)   


* PUT /api/clients/{id}: Update a client's information.
![image](https://user-images.githubusercontent.com/116377954/229309046-6b13d7bb-ef06-4a0e-a96e-6959bd12eb0c.png)
  
  
* DELETE /api/clients/{id}: Delete a client.
![image](https://user-images.githubusercontent.com/116377954/229309901-f181964e-08a0-42fe-8dcf-9869e7445080.png)



# Insurance Policies
* GET /api/policies: Fetch all insurance policies.
![image](https://user-images.githubusercontent.com/116377954/229309970-b302f295-3008-4066-aebe-db9c1f2628e7.png)

* GET /api/policies/{id}: Fetch a specific insurance policy by ID.
![image](https://user-images.githubusercontent.com/116377954/229309960-56bdcf65-249e-4bdd-82e8-f1bec2489c74.png)

* POST /api/policies: Create a new insurance policy.
![image](https://user-images.githubusercontent.com/116377954/229309304-45a09516-8b42-4ea1-86d7-4858ede2ac32.png)

* PUT /api/policies/{id}: Update an insurance policy.
![image](https://user-images.githubusercontent.com/116377954/229309396-4a25162b-8053-4747-ab4e-497869544b06.png)

* DELETE /api/policies/{id}: Delete an insurance policy.
![image](https://user-images.githubusercontent.com/116377954/229309983-411fe967-fd6b-4b47-b802-b5d84e50cf33.png)


  
  
# Claims
* GET /api/claims: Fetch all claims.   
![image](https://user-images.githubusercontent.com/116377954/229310185-71af3dff-3b12-450f-979b-5e1bd7228a81.png)

* GET /api/claims/{id}: Fetch a specific claim by ID.
![image](https://user-images.githubusercontent.com/116377954/229310101-08708bf0-a73e-4a0d-b9ef-3d9984e47ff0.png)

* POST /api/claims: Create a new claim.

(First save any insurance policy and then use its id as policyId here)
![image](https://user-images.githubusercontent.com/116377954/229309541-18ffff81-0a16-4d24-a86e-609deed7f03b.png)

* PUT /api/claims/{id}: Update a claim's information.
![image](https://user-images.githubusercontent.com/116377954/229309720-8e82062c-51dc-4fc8-bc11-39f0af9adab2.png)

* DELETE /api/claims/{id}: Delete a claim.
![image](https://user-images.githubusercontent.com/116377954/229310115-490a83c5-5f03-4d55-b16e-a8c8543d1b7f.png)

# Conclusion
This is a basic insurance management platform that can be further enhanced with additional features like a user interface, payment gateway integration, and email notifications.   


# Feedback
For any feedback or update, please connect with me mohdazmaan3@gmail.com
