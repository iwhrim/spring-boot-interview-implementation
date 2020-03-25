package dev.iwhrim.client.exceptions;

import dev.iwhrim.client.controller.ClientController;
import dev.iwhrim.client.dto.ClientRequestDto;
import dev.iwhrim.client.repositories.ClientRepository;
import dev.iwhrim.client.services.ClientServiceImp;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Optional;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ExceptionsTests {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientServiceImp clientService;

    private ClientController clientController = new ClientController();

    @Test(expected = InvalidParameterValueException.class)
    public void emptyNameShouldThrowInvalidParameterValueException() {
        String name = "";
        clientController.getClientByName(name);
    }

    @Test(expected = ClientNotFoundException.class)
    public void NonExistingClientShouldThrowClientNotFoundException() {
        String id = "6dsd5fd4a6a5fs6d";
        when(clientRepository.findById(id)).thenReturn(Optional.empty());
        clientService.getClientById(id);
    }

    @Test
    public void wrongDateFormatShouldThrowInvalidDateTimeFormatException() {
        ClientRequestDto clientRequestDto = new ClientRequestDto();

        clientRequestDto.setBirthDate("2000-01-01");
        Assertions.assertThatExceptionOfType(InvalidDateTimeFormatException.class)
                .isThrownBy(() ->  clientController.postClient(clientRequestDto));
    }

    @Test
    public void correctDateFormatShouldNotThrowInvalidDateTimeFormatException() {
        ClientRequestDto clientRequestDto = new ClientRequestDto();

        clientRequestDto.setBirthDate("2007-12-03T10:15:30+01:00[Europe/Paris]");
        Assertions.assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() ->  clientController.postClient(clientRequestDto));

        clientRequestDto.setBirthDate("2007-12-03T10:15:30+01:00");
        Assertions.assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() ->  clientController.postClient(clientRequestDto));
    }

}
