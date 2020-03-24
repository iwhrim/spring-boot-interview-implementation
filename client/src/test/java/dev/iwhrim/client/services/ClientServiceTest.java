package dev.iwhrim.client.services;

import dev.iwhrim.client.dto.ClientRequestDto;
import dev.iwhrim.client.dto.ClientResponseDto;
import dev.iwhrim.client.entities.Client;
import dev.iwhrim.client.repositories.ClientRepository;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
@RunWith(MockitoJUnitRunner.class)
public class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientServiceImp clientService;

    @Test
    public void shouldSaveClientRequestAndReturnClientResponse() {
        ClientRequestDto clientRequestDto = new ClientRequestDto(
                "User name",
                "Male",
                "2000-01-01",
                "City Name"
        );
        Client savedClient = clientRequestDto.toClient();
        savedClient.setId("5e7a1395ebc2df4b6c8f94da");
        when(clientRepository.save(clientRequestDto.toClient())).thenReturn(savedClient);

        Assertions.assertThat(clientService.saveClient(clientRequestDto)).isExactlyInstanceOf(ClientResponseDto.class);
        Assertions.assertThat(clientService.saveClient(clientRequestDto).getId())
                .isEqualTo("5e7a1395ebc2df4b6c8f94da");
        Assertions.assertThat(clientService.saveClient(clientRequestDto).getAge())
                .isGreaterThanOrEqualTo(20);
    }

}
