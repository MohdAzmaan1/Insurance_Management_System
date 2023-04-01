package com.example.Insurance_Management_Application.Service;

import com.example.Insurance_Management_Application.Convertor.ClientConvertor;
import com.example.Insurance_Management_Application.DTO.ClientEntryDto;
import com.example.Insurance_Management_Application.DTO.ClientUpdateDto;
import com.example.Insurance_Management_Application.Model.Client;
import com.example.Insurance_Management_Application.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }


    public Client getClientById(int id) throws Exception{
        if (!clientRepository.existsById(id)) {
            throw new Exception("Client not found");
        }else{
            return clientRepository.findById(id).get();
        }
    }


    public String createClient(ClientEntryDto clientEntryDto) {
        Client client = ClientConvertor.convertDtoToEntity(clientEntryDto);
        clientRepository.save(client);
        return "New Client is added with client id"+": "+client.getId();
    }


    public String updateClient(int id, ClientUpdateDto clientUpdateDto) throws Exception{
        if (!clientRepository.existsById(id)) {
            throw new Exception("Client not found");
        }else{
            Client existingClient = clientRepository.findById(id).get();
            existingClient.setName(clientUpdateDto.getName());
            existingClient.setDateOfBirth(clientUpdateDto.getDateOfBirth());
            existingClient.setAddress(clientUpdateDto.getAddress());
            existingClient.setContactInformation(clientUpdateDto.getContactInformation());
            clientRepository.save(existingClient);
            return "Client details are updated";
        }
    }


    public String deleteClient(int id) throws Exception{
        if (!clientRepository.existsById(id)) {
            throw new Exception("Client not found");
        }else{
            clientRepository.deleteById(id);
            return "Client deleted successfully";
        }
    }
}
