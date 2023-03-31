package com.example.Insurance_Management_Application.Repository;

import com.example.Insurance_Management_Application.Model.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Integer> {
}
