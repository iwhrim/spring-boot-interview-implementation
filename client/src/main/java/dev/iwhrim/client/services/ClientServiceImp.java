package dev.iwhrim.client.services;

import dev.iwhrim.client.dto.ClientRequestDto;
import dev.iwhrim.client.dto.ClientResponseDto;
import dev.iwhrim.client.entities.Client;
import dev.iwhrim.client.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImp {

    @Autowired
    private ClientRepository clientRepository;

    public ClientResponseDto saveClient(ClientRequestDto clientRequestDto) {
        System.out.println("clientRequestDto = " + clientRequestDto.toString());
        Client client = clientRequestDto.toClient();
        System.out.println("client = " + client.toString());
        Client savedClient = clientRepository.save(client);
        System.out.println("savedClient = " + savedClient.toString());
        ClientResponseDto clientResponseDto = savedClient.toResponseDto();
        System.out.println("clientResponseDto = " + clientResponseDto.toString());
        clientResponseDto.calculateAge();
        return clientResponseDto;
    }


}
