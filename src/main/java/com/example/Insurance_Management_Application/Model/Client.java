package com.example.Insurance_Management_Application.Model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private LocalDate dateOfBirth;

    private String address;

    private String contactInformation;

    @OneToMany(mappedBy = "client")
    List<InsurancePolicy> insurancePolicyList = new ArrayList<>();
}
