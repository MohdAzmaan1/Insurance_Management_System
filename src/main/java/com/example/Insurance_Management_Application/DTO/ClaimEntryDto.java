package com.example.Insurance_Management_Application.DTO;

import lombok.Data;

import java.util.UUID;

@Data
public class ClaimEntryDto {

    private String description;

    private String claimStatus;

    private int policyId;

    private String claimNumber = UUID.randomUUID().toString();
}
