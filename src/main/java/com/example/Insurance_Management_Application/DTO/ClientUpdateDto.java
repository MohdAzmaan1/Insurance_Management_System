package com.example.Insurance_Management_Application.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ClientUpdateDto {

    private String name;

    private LocalDate dateOfBirth;

    private String address;

    private String contactInformation;

}
