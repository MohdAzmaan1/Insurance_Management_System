package com.example.Insurance_Management_Application.Convertor;

import com.example.Insurance_Management_Application.DTO.ClaimEntryDto;
import com.example.Insurance_Management_Application.Model.Claim;
import com.example.Insurance_Management_Application.Model.Client;

public class ClaimConvertor {
    public static Claim convertDtoToEntity(ClaimEntryDto claimEntryDto){
        return Claim.builder()
                .description(claimEntryDto.getDescription())
                .claimStatus(claimEntryDto.getClaimStatus())
                .claimDate(claimEntryDto.getClaimDate())
                .insurancePolicy(claimEntryDto.getInsurancePolicy())
                .build();
    }
}
