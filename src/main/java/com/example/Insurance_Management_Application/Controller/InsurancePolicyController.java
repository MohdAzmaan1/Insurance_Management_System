package com.example.Insurance_Management_Application.Controller;

import com.example.Insurance_Management_Application.DTO.ErrorResponse;
import com.example.Insurance_Management_Application.DTO.InsurancePolicyResponseDto;
import com.example.Insurance_Management_Application.Model.InsurancePolicy;
import com.example.Insurance_Management_Application.Service.InsurancePolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policies")
public class InsurancePolicyController {

    @Autowired
    private InsurancePolicyService insurancePolicyService;


    //  Fetch all insurance policies. GET API  -  localhost:8080/api/policies
    @GetMapping
    public List<InsurancePolicyResponseDto> getAllInsurancePolicies() {
        return insurancePolicyService.getAllInsurancePolicies();
    }



    // Fetch a specific insurance policy by ID:   GET API  -  localhost:8080/api/policies/{id}
    @GetMapping("/{id}")
    public ResponseEntity<?> getInsurancePolicyById(@PathVariable(value = "id") int Id) {
        try{
            return new ResponseEntity<>(insurancePolicyService.getInsurancePolicyById(Id), HttpStatus.FOUND);
        }catch (Exception e){
            ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
    }



    //  Create a new insurance policy. POST API   -   localhost:8080/api/policies
    @PostMapping
    public ResponseEntity<InsurancePolicyResponseDto> createInsurancePolicy(@RequestBody InsurancePolicy policy) {
        return new ResponseEntity<>(insurancePolicyService.createInsurancePolicy(policy), HttpStatus.CREATED);
    }
    //JSON For Postman:
    // {
    //    "type":"Type of policy",
    //    "coverageAmount": Enter amount in digits,
    //    "premium":  Enter premium amount in digits,
    //    "endDate":"yyyy-mm-dd"
    //}




    // Update an insurance policy.  - PUT API   -   localhost:8080/api/policies/{id}
    @PutMapping("/{id}")
    public ResponseEntity<?> updateInsurancePolicy(@PathVariable(value = "id") int Id, @RequestBody InsurancePolicy policyDetails) {
        try{
            return new ResponseEntity<>(insurancePolicyService.updateInsurancePolicy(Id, policyDetails), HttpStatus.CREATED);
        }catch (Exception e){
            ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
    }
    //Enter the values that you want to update
    //JSON For Postman:
    // {
    //    "type":"Type of policy",
    //    "coverageAmount": Enter amount in digits,
    //    "premium":  Enter premium amount in digits,
    //    "endDate":"yyyy-mm-dd"
    //}




    // Delete an insurance policy:   DELETE API   -   localhost:8080/api/policies/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInsurancePolicy(@PathVariable(value = "id") int Id){
        try{
            String response = insurancePolicyService.deleteInsurancePolicy(Id);
            return new ResponseEntity<>(response, HttpStatus.FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
