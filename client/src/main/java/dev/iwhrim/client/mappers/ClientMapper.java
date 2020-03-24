package dev.iwhrim.client.mappers;

import dev.iwhrim.client.dto.ClientResponseDto;
import dev.iwhrim.client.entities.Client;
import org.modelmapper.ModelMapper;

public abstract class ClientMapper {

    public Client toClient() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, Client.class);
    }

    public ClientResponseDto toResponseDto() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, ClientResponseDto.class);
    }

}
