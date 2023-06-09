package com.example.Insurance_Management_Application.Model;

import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "claims")
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String claimNumber = UUID.randomUUID().toString();

    private String description;

    @CreationTimestamp
    private LocalDate claimDate;

    private String claimStatus;

    @ManyToOne
    @JoinColumn
    private InsurancePolicy insurancePolicy;

}
