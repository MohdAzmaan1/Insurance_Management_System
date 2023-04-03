# Insurance_Management_System
This is an insurance management platform built using Spring Boot and Java. The platform allows users to manage insurance policies, clients, and claims through a RESTful API.


# Design of the Application
![image](https://user-images.githubusercontent.com/116377954/229338637-f878114d-09e9-41aa-8d78-690be33aae27.png)


# Requirements and Technology used
* Java 11 or higher (Here, I have used Java version 17)
* Spring Boot 2.7.10
* Spring Data JPA
* Maven
* Apache Derby Database
* Postman
 
Note: Here, Derby is used as an in-memory database

# Setup
* Clone the repository
* Open the project in an IDE (Here, I have used Intelli J)
* Build the project using Maven: mvn clean install
* Run the project
* Test the API on postman through mentioned endpoints

# API Endpoints
The following endpoints are available:

# Clients
* GET /api/clients: Fetch all clients.  
![image](https://user-images.githubusercontent.com/116377954/229337081-26646c2a-e8ad-487d-ab02-5a2b8613989c.png)  


* GET /api/clients/{id}: Fetch a specific client by ID.
![image](https://user-images.githubusercontent.com/116377954/229337102-0d8c1fea-aa4e-42ef-9228-f11863305039.png) 


* POST /api/clients: Create a new client.
![image](https://user-images.githubusercontent.com/116377954/229337136-ce2323c2-a5c8-4bc2-a592-ef1adf923f1f.png)  


* PUT /api/clients/{id}: Update a client's information.
![image](https://user-images.githubusercontent.com/116377954/229337192-b9ee62cc-5a07-45c9-8447-1d8a9d444bf5.png)
  
  
* DELETE /api/clients/{id}: Delete a client.
![image](https://user-images.githubusercontent.com/116377954/229309901-f181964e-08a0-42fe-8dcf-9869e7445080.png)



# Insurance Policies
* GET /api/policies: Fetch all insurance policies.
![image](https://user-images.githubusercontent.com/116377954/229338086-8074a16b-ad5f-4ce3-8495-9055e680701a.png)

* GET /api/policies/{id}: Fetch a specific insurance policy by ID.
![image](https://user-images.githubusercontent.com/116377954/229338077-f932db6a-6283-476e-babd-4270de11cd38.png)

* POST /api/policies: Create a new insurance policy.
![image](https://user-images.githubusercontent.com/116377954/229337993-2269c22b-184d-4dd0-8bae-acc8c12e2ca7.png)

* PUT /api/policies/{id}: Update an insurance policy.
![image](https://user-images.githubusercontent.com/116377954/229338053-ef60ab58-cc77-449e-9e32-222276b133e0.png)

* DELETE /api/policies/{id}: Delete an insurance policy.
![image](https://user-images.githubusercontent.com/116377954/229309983-411fe967-fd6b-4b47-b802-b5d84e50cf33.png)


  
  
# Claims
* GET /api/claims: Fetch all claims.   
![image](https://user-images.githubusercontent.com/116377954/229338547-26f0cdcb-fd9c-4efa-85bc-b63e7d907ac2.png)

* GET /api/claims/{id}: Fetch a specific claim by ID.
![image](https://user-images.githubusercontent.com/116377954/229338552-e6047c59-0249-49df-a334-509ba9bc6b7d.png)

* POST /api/claims: Create a new claim.

(First save any insurance policy and then use its id as policyId here)
![image](https://user-images.githubusercontent.com/116377954/229338527-79e337ad-ee67-4eee-8785-110635308c99.png)

* PUT /api/claims/{id}: Update a claim's information.
![image](https://user-images.githubusercontent.com/116377954/229338573-51f3a2cc-544c-4bdb-847c-c25b33641e1e.png)

* DELETE /api/claims/{id}: Delete a claim.
![image](https://user-images.githubusercontent.com/116377954/229310115-490a83c5-5f03-4d55-b16e-a8c8543d1b7f.png)

# Conclusion
This is a basic insurance management platform that can be further enhanced with additional features like a user interface, payment gateway integration, and email notifications.   


# Feedback
For any feedback or update, please connect with me mohdazmaan3@gmail.com
