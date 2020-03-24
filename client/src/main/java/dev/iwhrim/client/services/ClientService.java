package dev.iwhrim.client.services;

import dev.iwhrim.client.dto.ClientRequestDto;
import dev.iwhrim.client.dto.ClientResponseDto;

import java.util.List;

public interface ClientService {
    public ClientResponseDto saveClient(ClientRequestDto clientRequestDto);
    public List<ClientResponseDto> getClientByName(String name);
}
