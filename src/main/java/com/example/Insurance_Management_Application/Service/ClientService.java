package com.example.Insurance_Management_Application.Service;

import com.example.Insurance_Management_Application.Convertor.ClientConvertor;
import com.example.Insurance_Management_Application.DTO.ClientEntryDto;
import com.example.Insurance_Management_Application.DTO.ClientResponseDto;
import com.example.Insurance_Management_Application.DTO.ClientUpdateDto;
import com.example.Insurance_Management_Application.Model.Client;
import com.example.Insurance_Management_Application.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<ClientResponseDto> getAllClients(){
        List<ClientResponseDto> clientResponseDtoList = new ArrayList<>();

        for(Client client : clientRepository.findAll()){
            ClientResponseDto clientResponseDto = new ClientResponseDto();
            clientResponseDto.setId(client.getId());
            clientResponseDto.setAddress(client.getAddress());
            clientResponseDto.setName(client.getName());
            clientResponseDto.setContactInformation(client.getContactInformation());
            clientResponseDto.setDateOfBirth(client.getDateOfBirth());
            clientResponseDtoList.add(clientResponseDto);
        }
        return clientResponseDtoList;
    }


    public ClientResponseDto getClientById(int id) throws Exception{
        if (!clientRepository.existsById(id)) {
            throw new Exception("Client not found");
        }else{
            ClientResponseDto clientResponseDto = new ClientResponseDto();
            Client client = clientRepository.findById(id).get();

            clientResponseDto.setAddress(client.getAddress());
            clientResponseDto.setId(client.getId());
            clientResponseDto.setName(client.getName());
            clientResponseDto.setContactInformation(client.getContactInformation());
            clientResponseDto.setDateOfBirth(client.getDateOfBirth());

            return clientResponseDto;
        }
    }


    public ClientResponseDto createClient(ClientEntryDto clientEntryDto) {
        ClientResponseDto clientResponseDto = new ClientResponseDto();
        Client client = ClientConvertor.convertDtoToEntity(clientEntryDto);
        clientRepository.save(client);

        clientResponseDto.setAddress(client.getAddress());
        clientResponseDto.setId(client.getId());
        clientResponseDto.setName(client.getName());
        clientResponseDto.setContactInformation(client.getContactInformation());
        clientResponseDto.setDateOfBirth(client.getDateOfBirth());

        return clientResponseDto;
    }


    public ClientResponseDto updateClient(int id, ClientUpdateDto clientUpdateDto) throws Exception{
        if (!clientRepository.existsById(id)) {
            throw new Exception("Client not found");
        }else{
            Client existingClient = clientRepository.findById(id).get();
            existingClient.setName(clientUpdateDto.getName());
            existingClient.setDateOfBirth(clientUpdateDto.getDateOfBirth());
            existingClient.setAddress(clientUpdateDto.getAddress());
            existingClient.setContactInformation(clientUpdateDto.getContactInformation());
            clientRepository.save(existingClient);

            ClientResponseDto clientResponseDto = new ClientResponseDto();
            clientResponseDto.setAddress(existingClient.getAddress());
            clientResponseDto.setId(existingClient.getId());
            clientResponseDto.setName(existingClient.getName());
            clientResponseDto.setContactInformation(existingClient.getContactInformation());
            clientResponseDto.setDateOfBirth(existingClient.getDateOfBirth());

            return clientResponseDto;
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
