package com.example.Insurance_Management_Application.Service;

import com.example.Insurance_Management_Application.Model.InsurancePolicy;
import com.example.Insurance_Management_Application.Repository.InsurancePolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class InsurancePolicyService {

    @Autowired
    private InsurancePolicyRepository insurancePolicyRepository;


    public List<InsurancePolicy> getAllInsurancePolicies() {
        return insurancePolicyRepository.findAll();
    }


    public InsurancePolicy getInsurancePolicyById(int Id) throws Exception {
        if (!insurancePolicyRepository.existsById(Id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Insurance Policy not found");
        }else{
            return insurancePolicyRepository.findById(Id).get();
        }
    }


    public String createInsurancePolicy(InsurancePolicy policy) {
        insurancePolicyRepository.save(policy);
        return "New Insurance Policy is added";
    }


    public String updateInsurancePolicy(int Id, InsurancePolicy policyDetails)throws Exception {
        if (!insurancePolicyRepository.existsById(Id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Insurance Policy not found");
        }else{
            InsurancePolicy policy = getInsurancePolicyById(Id);
            policy.setPolicyNumber(policyDetails.getPolicyNumber());
            policy.setType(policyDetails.getType());
            policy.setCoverageAmount(policyDetails.getCoverageAmount());
            policy.setPremium(policyDetails.getPremium());
            policy.setStartDate(policyDetails.getStartDate());
            policy.setEndDate(policyDetails.getEndDate());
            policy.setClient(policyDetails.getClient());

            insurancePolicyRepository.save(policy);
            return "Insurance Policy details are updated";
        }
    }

    public String deleteInsurancePolicy(int Id) throws Exception {
        if (!insurancePolicyRepository.existsById(Id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Insurance Policy not found");
        }else{
            InsurancePolicy policy = getInsurancePolicyById(Id);
            insurancePolicyRepository.delete(policy);
            return "Insurance policy deleted";
        }
    }
}

