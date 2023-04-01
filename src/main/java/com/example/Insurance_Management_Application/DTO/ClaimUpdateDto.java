package com.example.Insurance_Management_Application.DTO;

import lombok.Data;

@Data
public class ClaimUpdateDto {

    private String description;

    private String claimStatus;

    private int claimId;

    private int policyId;
}
