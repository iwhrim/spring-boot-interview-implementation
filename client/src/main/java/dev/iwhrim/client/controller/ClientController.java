package dev.iwhrim.client.controller;

import dev.iwhrim.client.dto.ClientRequestDto;
import dev.iwhrim.client.dto.ClientResponseDto;
import dev.iwhrim.client.services.ClientServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<ClientResponseDto>> getClientByName(@NotNull @NotEmpty @RequestParam(value = "name") String name) {
        List<ClientResponseDto> clientsListByName = clientService.getClientByName(name);
        return new ResponseEntity<>(clientsListByName, HttpStatus.OK);
    }

//     TODO: 24/03/2020
//    @GetMapping("/{id}")


}
