package com.example.Insurance_Management_Application.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ClientEntryDto {

    private String name;

    private String address;

    private String contactInformation;

    private LocalDate dateOfBirth;
}
