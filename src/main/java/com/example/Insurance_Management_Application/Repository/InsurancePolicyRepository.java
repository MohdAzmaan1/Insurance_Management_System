package com.example.Insurance_Management_Application.Repository;

import com.example.Insurance_Management_Application.Model.InsurancePolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy, Integer> {

}
