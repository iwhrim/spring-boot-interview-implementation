package dev.iwhrim.client.services;

import dev.iwhrim.client.dto.ClientRequestDto;
import dev.iwhrim.client.dto.ClientResponseDto;
import dev.iwhrim.client.entities.Client;
import dev.iwhrim.client.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImp implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public ClientResponseDto saveClient(ClientRequestDto clientRequestDto) {
        Client client = clientRequestDto.toClient();
        Client savedClient = clientRepository.save(client);
        ClientResponseDto clientResponseDto = savedClient.toResponseDto();
        clientResponseDto.calculateAge();
        return clientResponseDto;
    }

    public List<ClientResponseDto> getClientByName(String name) {
        List<Client> clients = clientRepository.findAllByCompleteNameContaining(name);
        List<ClientResponseDto> clientResponseList = new ArrayList<>();
        clients.forEach(client -> {
            clientResponseList.add(client.toResponseDto());
        });
        clientResponseList.forEach(ClientResponseDto::calculateAge);
        return clientResponseList;
    }

}
