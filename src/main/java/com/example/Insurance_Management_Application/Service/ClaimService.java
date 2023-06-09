package com.example.Insurance_Management_Application.Service;

import com.example.Insurance_Management_Application.Convertor.ClaimConvertor;
import com.example.Insurance_Management_Application.DTO.ClaimEntryDto;
import com.example.Insurance_Management_Application.DTO.ClaimResponseDto;
import com.example.Insurance_Management_Application.DTO.ClaimUpdateDto;
import com.example.Insurance_Management_Application.Model.Claim;
import com.example.Insurance_Management_Application.Model.InsurancePolicy;
import com.example.Insurance_Management_Application.Repository.ClaimRepository;
import com.example.Insurance_Management_Application.Repository.InsurancePolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClaimService {

    @Autowired
    private ClaimRepository claimRepository;

    @Autowired
    private InsurancePolicyRepository insurancePolicyRepository;


    public List<ClaimResponseDto> getAllClaims() {
        List<ClaimResponseDto> claimResponseDtoList = new ArrayList<>();

        for(Claim claim : claimRepository.findAll()){
            ClaimResponseDto claimResponseDto = new ClaimResponseDto();
            claimResponseDto.setId(claim.getId());
            claimResponseDto.setClaimNumber(claim.getClaimNumber());
            claimResponseDto.setClaimDate(claim.getClaimDate());
            claimResponseDto.setClaimStatus(claim.getClaimStatus());
            claimResponseDto.setDescription(claim.getDescription());
            claimResponseDtoList.add(claimResponseDto);
        }
        return claimResponseDtoList;
    }


    public ClaimResponseDto getClaimById(int id) throws Exception{
        if(!claimRepository.existsById(id)){
            throw new Exception("Claim details not found");
        }else{
            ClaimResponseDto claimResponseDto = new ClaimResponseDto();
            Claim claim = claimRepository.findById(id).get();
            claimResponseDto.setClaimDate(claim.getClaimDate());
            claimResponseDto.setClaimStatus(claim.getClaimStatus());
            claimResponseDto.setDescription(claim.getDescription());
            claimResponseDto.setClaimNumber(claim.getClaimNumber());
            claimResponseDto.setId(claim.getId());
            return claimResponseDto;
        }
    }


    public ClaimResponseDto createClaim(ClaimEntryDto claimEntryDto){
        String claimNumber = claimEntryDto.getClaimNumber();
        InsurancePolicy insurancePolicy = insurancePolicyRepository.findById(claimEntryDto.getPolicyId()).get();
        Claim claim = ClaimConvertor.convertDtoToEntity(claimEntryDto);
        claim.setInsurancePolicy(insurancePolicy);
        claim.setClaimNumber(claimNumber);
        Claim updatedClaim = claimRepository.save(claim);

        ClaimResponseDto responseDto = new ClaimResponseDto();
        responseDto.setClaimDate(updatedClaim.getClaimDate());
        responseDto.setClaimStatus(updatedClaim.getClaimStatus());
        responseDto.setDescription(updatedClaim.getDescription());
        responseDto.setClaimNumber(claimNumber);
        responseDto.setId(claim.getId());
        return responseDto;
    }


    public ClaimResponseDto updateClaim(int id, ClaimUpdateDto claimUpdateDto) throws Exception {
        if(!claimRepository.existsById(id)){
            throw new Exception("Claim details not found");
        }else{
            Claim claim = claimRepository.findById(id).get();
            claim.setDescription(claimUpdateDto.getDescription());
            claim.setClaimStatus(claimUpdateDto.getClaimStatus());
            claimRepository.save(claim);

            ClaimResponseDto responseDto = new ClaimResponseDto();
            responseDto.setClaimDate(claim.getClaimDate());
            responseDto.setClaimStatus(claim.getClaimStatus());
            responseDto.setDescription(claim.getDescription());
            responseDto.setClaimNumber(claim.getClaimNumber());
            responseDto.setId(claim.getId());
            return responseDto;
        }
    }


    public String deleteClaim(int id) throws Exception{
        if (!claimRepository.existsById(id)){
            throw new Exception("Claim details not found");
        }else{
            Claim claim = claimRepository.findById(id).get();
            claimRepository.delete(claim);
            return "Claim details deleted successfully";
        }
    }
}
