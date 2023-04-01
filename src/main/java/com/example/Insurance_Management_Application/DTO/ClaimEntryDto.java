package com.example.Insurance_Management_Application.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ClaimEntryDto {

    private String description;

    private String claimStatus;

    private int policyId;
}