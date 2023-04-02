package com.example.Insurance_Management_Application.Controller;

import com.example.Insurance_Management_Application.DTO.ClientEntryDto;
import com.example.Insurance_Management_Application.DTO.ClientResponseDto;
import com.example.Insurance_Management_Application.DTO.ClientUpdateDto;
import com.example.Insurance_Management_Application.DTO.ErrorResponse;
import com.example.Insurance_Management_Application.Model.Client;
import com.example.Insurance_Management_Application.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<ClientResponseDto> getAllClients(){
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClientById(@PathVariable(value = "id") int id) {
        try{
            return new ResponseEntity<>(clientService.getClientById(id), HttpStatus.FOUND);
        }catch (Exception e){
            ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ClientResponseDto> createClient(@RequestBody ClientEntryDto clientEntryDto) {
        return new ResponseEntity<>(clientService.createClient(clientEntryDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateClient(@PathVariable(value = "id") int id, @RequestBody ClientUpdateDto clientUpdateDto){
        try{
            return new ResponseEntity<>(clientService.updateClient(id, clientUpdateDto), HttpStatus.OK);
        }catch (Exception e){
            ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable(value = "id") int id){
        try{
            String response = clientService.deleteClient(id);
            return new ResponseEntity<>(response, HttpStatus.FOUND);
        }catch (Exception e){
            return new ResponseEntity<>("Client not found", HttpStatus.NOT_FOUND);
        }
    }
}
