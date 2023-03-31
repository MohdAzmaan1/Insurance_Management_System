package com.example.Insurance_Management_Application.Model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table
public class InsurancePolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String policyNumber = UUID.randomUUID().toString();

    private String type;

    private Double coverageAmount;

    private Double premium;

    private LocalDate startDate;

    private LocalDate endDate;

    @ManyToOne
    @JoinColumn
    private Client client;

    @OneToMany(mappedBy = "insurancePolicy")
    private List<Claim> claimList = new ArrayList<>();
}
