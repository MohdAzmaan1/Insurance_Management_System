package com.example.Insurance_Management_Application.Convertor;

import com.example.Insurance_Management_Application.DTO.ClientEntryDto;
import com.example.Insurance_Management_Application.Model.Client;

public class ClientConvertor {

    public static Client convertDtoToEntity(ClientEntryDto clientEntryDto){
        return Client.builder().name(clientEntryDto.getName())
                .address(clientEntryDto.getAddress())
                .dateOfBirth(clientEntryDto.getDateOfBirth())
                .contactInformation(clientEntryDto.getContactInformation())
                .build();
    }
}
