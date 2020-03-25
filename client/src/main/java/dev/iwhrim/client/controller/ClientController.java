package dev.iwhrim.client.controller;

import dev.iwhrim.client.dto.ClientRequestDto;
import dev.iwhrim.client.dto.ClientResponseDto;
import dev.iwhrim.client.exceptions.InvalidDateTimeFormatException;
import dev.iwhrim.client.exceptions.InvalidParameterValueException;
import dev.iwhrim.client.services.ClientServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientServiceImp clientService;

    @PostMapping
    public ResponseEntity<ClientResponseDto> postClient(@Valid @RequestBody ClientRequestDto clientRequestDto) {
        if (!clientRequestDto.isValidBirthDate()) throw new InvalidDateTimeFormatException();
        ClientResponseDto clientResponseDto = clientService.saveClient(clientRequestDto);
        return new ResponseEntity<>(clientResponseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ClientResponseDto>> getClientByName(@NotNull @RequestParam(value = "name") String name) {
        if (name.isEmpty()) throw new InvalidParameterValueException();
        List<ClientResponseDto> clientResponseDtoList = clientService.getClientByName(name);
        return new ResponseEntity<>(clientResponseDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDto> getClientById(@PathVariable(value = "id") String id) {
        ClientResponseDto clientResponseDto = clientService.getClientById(id);
        return new ResponseEntity<>(clientResponseDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientResponseDto> changeClientName(@PathVariable(value = "id") String id,
                                                              @NotNull @RequestParam(value = "name") String name) {
        ClientResponseDto clientResponseDto = clientService.changeClientName(id, name);
        return new ResponseEntity<>(clientResponseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable(value = "id") String id) {
        clientService.removeClient(id);
        return ResponseEntity.ok().build();
    }

}
