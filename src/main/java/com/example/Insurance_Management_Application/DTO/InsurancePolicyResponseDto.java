package com.example.Insurance_Management_Application.DTO;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class InsurancePolicyResponseDto {

    private int id;

    private String policyNumber = UUID.randomUUID().toString();

    private String type;

    private Double coverageAmount;

    private Double premium;

    private LocalDate endDate;
}
