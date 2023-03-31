package com.example.Insurance_Management_Application.DTO;

import com.example.Insurance_Management_Application.Model.InsurancePolicy;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ClaimEntryDto {

    private String description;

    private LocalDate claimDate;

    private String claimStatus;

    private InsurancePolicy insurancePolicy;
}
