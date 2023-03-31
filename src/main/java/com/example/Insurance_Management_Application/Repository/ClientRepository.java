package com.example.Insurance_Management_Application.Repository;

import com.example.Insurance_Management_Application.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
