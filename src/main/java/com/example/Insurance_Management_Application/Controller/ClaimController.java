package com.example.Insurance_Management_Application.Controller;

import com.example.Insurance_Management_Application.DTO.ClaimEntryDto;
import com.example.Insurance_Management_Application.DTO.ClaimResponseDto;
import com.example.Insurance_Management_Application.DTO.ClaimUpdateDto;
import com.example.Insurance_Management_Application.DTO.ErrorResponse;
import com.example.Insurance_Management_Application.Model.Claim;
import com.example.Insurance_Management_Application.Service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {

    @Autowired
    private ClaimService claimService;


    // Fetch all claims:     GET API    -   localhost:8080/api/claims
    @GetMapping
    public List<ClaimResponseDto> getAllClaims() {
        return claimService.getAllClaims();
    }



    // Fetch a specific claim by ID:    GET API    -   localhost:8080/api/claims/{id}
    @GetMapping("/{id}")
    public ResponseEntity<?> getClaimById(@PathVariable(value = "id") int id){
        try{
            return new ResponseEntity<>(claimService.getClaimById(id), HttpStatus.FOUND);
        }catch (Exception e){
            ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
    }




    // Create a new claim:     POST API    -   localhost:8080/api/claims
    @PostMapping
    public ResponseEntity<ClaimResponseDto> createClaim(@RequestBody ClaimEntryDto claimEntryDto) {
        return new ResponseEntity<>(claimService.createClaim(claimEntryDto), HttpStatus.CREATED);
    }
    // JSON for Postman
    // {
    //    "description" : "Enter the description status",
    //    "claimStatus":"Enter the claim status",
    //    "policyId": Enter the id of existing insurance policy.
    //}





    // Update a claim's information:    PUT API    -    localhost:8080/api/claims/{id}
    @PutMapping("/{id}")
    public ResponseEntity<?> updateClaim(@PathVariable int id, @RequestBody ClaimUpdateDto claimUpdateDto){
        try{
            return new ResponseEntity<>(claimService.updateClaim(id, claimUpdateDto), HttpStatus.OK);
        }catch (Exception e){
            ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
    }
    // Enter the values that you want to update
    // JSON for Postman
    // {
    //    "description" : "Enter the description status",
    //    "claimStatus":"Enter the claim status",
    //    "policyId": Enter the insurance policy id that you have already created
    //}





    //  Delete a claim:    DELETE API   -    localhost:8080/api/claims{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClaim(@PathVariable(value = "id") int id) {
        try{
            String response = claimService.deleteClaim(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
