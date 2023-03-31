package com.example.Insurance_Management_Application.Service;

import com.example.Insurance_Management_Application.Convertor.ClaimConvertor;
import com.example.Insurance_Management_Application.DTO.ClaimEntryDto;
import com.example.Insurance_Management_Application.DTO.ClaimUpdateDto;
import com.example.Insurance_Management_Application.Model.Claim;
import com.example.Insurance_Management_Application.Model.InsurancePolicy;
import com.example.Insurance_Management_Application.Repository.ClaimRepository;
import com.example.Insurance_Management_Application.Repository.InsurancePolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ClaimService {

    @Autowired
    private ClaimRepository claimRepository;

    @Autowired
    private InsurancePolicyRepository insurancePolicyRepository;


    public List<Claim> getAllClaims() {
        return claimRepository.findAll();
    }


    public Claim getClaimById(int id) throws Exception{
        if(!claimRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Claim details not found");
        }else{
            return claimRepository.findById(id).get();
        }
    }


    public String createClaim(ClaimEntryDto claimEntryDto){
        Claim claim = ClaimConvertor.convertDtoToEntity(claimEntryDto);
        InsurancePolicy policy = insurancePolicyRepository.findById(claim.getInsurancePolicy().getId()).orElseThrow();

        claim.setInsurancePolicy(policy);
        claimRepository.save(claim);
        return "Claim details are added";
    }


    public String updateClaim(int id, ClaimUpdateDto claimUpdateDto) throws Exception {
        if(!claimRepository.existsById(id)){
            throw new Exception("Claim Details are not found");
        }else{
            Claim claim = getClaimById(id);
            claim.setDescription(claimUpdateDto.getDescription());
            claim.setClaimDate(claimUpdateDto.getClaimDate());
            claim.setClaimStatus(claimUpdateDto.getClaimStatus());
            InsurancePolicy policy = insurancePolicyRepository.findById(claimUpdateDto.getInsurancePolicy().getId()).orElseThrow();

            claim.setInsurancePolicy(policy);
            claimRepository.save(claim);
            return "Claim details are updated";
        }
    }


    public String deleteClaim(int id) throws Exception{
        if (!claimRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Claim not found");
        }else{
            claimRepository.deleteById(id);
            return "Client details deleted successfully";
        }
    }
}
