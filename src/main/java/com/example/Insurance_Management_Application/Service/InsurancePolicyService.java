package com.example.Insurance_Management_Application.Service;

import com.example.Insurance_Management_Application.DTO.InsurancePolicyResponseDto;
import com.example.Insurance_Management_Application.Model.InsurancePolicy;
import com.example.Insurance_Management_Application.Repository.InsurancePolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class InsurancePolicyService {

    @Autowired
    private InsurancePolicyRepository insurancePolicyRepository;


    public List<InsurancePolicyResponseDto> getAllInsurancePolicies() {
        List<InsurancePolicyResponseDto> insurancePolicyResponseDtoList = new ArrayList<>();
        for(InsurancePolicy policy : insurancePolicyRepository.findAll()){
            InsurancePolicyResponseDto policyResponseDto = new InsurancePolicyResponseDto();
            policyResponseDto.setId(policy.getId());
            policyResponseDto.setPolicyNumber(policy.getPolicyNumber());
            policyResponseDto.setCoverageAmount(policy.getCoverageAmount());
            policyResponseDto.setPremium(policy.getPremium());
            policyResponseDto.setType(policy.getType());
            insurancePolicyResponseDtoList.add(policyResponseDto);
        }
        return insurancePolicyResponseDtoList;
    }


    public InsurancePolicyResponseDto getInsurancePolicyById(int Id) throws Exception {
        if (!insurancePolicyRepository.existsById(Id)) {
            throw new Exception("Insurance Policy not found");
        }else{
            InsurancePolicy policy = insurancePolicyRepository.findById(Id).get();
            InsurancePolicyResponseDto policyResponseDto = new InsurancePolicyResponseDto();
            policyResponseDto.setId(policy.getId());
            policyResponseDto.setPolicyNumber(policy.getPolicyNumber());
            policyResponseDto.setCoverageAmount(policy.getCoverageAmount());
            policyResponseDto.setPremium(policy.getPremium());
            policyResponseDto.setType(policy.getType());
            return policyResponseDto;
        }
    }


    public String createInsurancePolicy(InsurancePolicy policy) {
        insurancePolicyRepository.save(policy);
        return "New Insurance Policy is added";
    }


    public String updateInsurancePolicy(int Id, InsurancePolicy policyDetails)throws Exception {
        if (!insurancePolicyRepository.existsById(Id)) {
            throw new Exception("Insurance Policy not found");
        }else{
            InsurancePolicy policy = insurancePolicyRepository.findById(Id).get();
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
            throw new Exception("Insurance Policy not found");
        }else{
            InsurancePolicy policy = insurancePolicyRepository.findById(Id).get();
            insurancePolicyRepository.delete(policy);
            return "Insurance policy deleted";
        }
    }
}

