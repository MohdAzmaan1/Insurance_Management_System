package com.example.Insurance_Management_Application.Controller;

import com.example.Insurance_Management_Application.DTO.ClaimEntryDto;
import com.example.Insurance_Management_Application.DTO.ClaimUpdateDto;
import com.example.Insurance_Management_Application.Model.Claim;
import com.example.Insurance_Management_Application.Service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(" /api/claims")
public class ClaimController {

    @Autowired
    private ClaimService claimService;

    @GetMapping
    public List<Claim> getAllClaims() {
        return claimService.getAllClaims();
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getClaimById(@PathVariable(value = "id") int id) throws Exception{
        try{
            return new ResponseEntity<>(claimService.getClaimById(id).toString(), HttpStatus.FOUND);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Claim details are not found");
        }
    }

    @PostMapping
    public ResponseEntity<String> createClaim(@RequestBody ClaimEntryDto claimEntryDto) throws Exception {
        return new ResponseEntity<>(claimService.createClaim(claimEntryDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateClaim(@PathVariable int id, @RequestBody ClaimUpdateDto claimUpdateDto) throws Exception{
        try{
            return new ResponseEntity<>(claimService.updateClaim(id, claimUpdateDto), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

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
