package dev.iwhrim.client.services;

import dev.iwhrim.client.dto.ClientRequestDto;
import dev.iwhrim.client.dto.ClientResponseDto;
import dev.iwhrim.client.entities.Client;
import dev.iwhrim.client.exceptions.ClientNotFoundException;
import dev.iwhrim.client.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImp implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public ClientResponseDto saveClient(ClientRequestDto clientRequestDto) {
        Client client = clientRequestDto.toClient();
        Client savedClient = clientRepository.save(client);
        return savedClient.toResponseDto();
    }

    @Override
    public List<ClientResponseDto> getClientByName(String name) {
        List<Client> clients = clientRepository.findAllByCompleteNameContaining(name);
        List<ClientResponseDto> clientResponseList = new ArrayList<>();
        clients.forEach(client -> clientResponseList.add(client.toResponseDto()));
        return clientResponseList;
    }

    @Override
    public ClientResponseDto getClientById(String id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (!optionalClient.isPresent()) throw new ClientNotFoundException();
        return optionalClient.get().toResponseDto();
    }

    @Override
    public void removeClient(String id) {
        clientRepository.deleteById(id);
    }

    @Override
    public ClientResponseDto changeClientName(String id, String newName) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (!optionalClient.isPresent()) throw new ClientNotFoundException();

        Client client = optionalClient.get();
        client.setCompleteName(newName);
        Client savedClient = clientRepository.save(client);

        return savedClient.toResponseDto();
    }

}
