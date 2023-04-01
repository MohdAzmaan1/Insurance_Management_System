package com.example.Insurance_Management_Application.Controller;

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


    @GetMapping
    public List<InsurancePolicyResponseDto> getAllInsurancePolicies() {
        return insurancePolicyService.getAllInsurancePolicies();
    }


    @GetMapping("/{id}")
    public ResponseEntity<String> getInsurancePolicyById(@PathVariable(value = "id") int Id) {
        try{
            return new ResponseEntity<>(insurancePolicyService.getInsurancePolicyById(Id).toString(), HttpStatus.FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping
    public ResponseEntity<String> createInsurancePolicy(@RequestBody InsurancePolicy policy) {
        return new ResponseEntity<>(insurancePolicyService.createInsurancePolicy(policy), HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> updateInsurancePolicy(@PathVariable(value = "id") int Id, @RequestBody InsurancePolicy policyDetails) {
        try{
            return new ResponseEntity<>(insurancePolicyService.updateInsurancePolicy(Id, policyDetails), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


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
