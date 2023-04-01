package com.example.Insurance_Management_Application.DTO;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class ClaimResponseDto {

    private int id;

    private String description;

    private LocalDate claimDate;

    private String claimStatus;

    private String claimNumber;

}
