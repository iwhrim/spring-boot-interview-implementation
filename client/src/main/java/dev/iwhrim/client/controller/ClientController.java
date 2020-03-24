package dev.iwhrim.client.controller;

import dev.iwhrim.client.dto.ClientRequestDto;
import dev.iwhrim.client.dto.ClientResponseDto;
import dev.iwhrim.client.services.ClientServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientServiceImp clientService;

    @PostMapping
    public ResponseEntity<ClientResponseDto> postClient(@Valid @RequestBody ClientRequestDto clientRequestDto) {
        ClientResponseDto clientResponseDto = clientService.saveClient(clientRequestDto);
        return new ResponseEntity<>(clientResponseDto, HttpStatus.CREATED);
    }

}
