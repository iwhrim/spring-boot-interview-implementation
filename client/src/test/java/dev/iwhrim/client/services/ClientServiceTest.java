package dev.iwhrim.client.services;

import dev.iwhrim.client.dto.ClientRequestDto;
import dev.iwhrim.client.dto.ClientResponseDto;
import dev.iwhrim.client.entities.Client;
import dev.iwhrim.client.repositories.ClientRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
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

    public Client client = new Client(
            "5e7a559db16e3f79ccbe20ce",
            "User name",
            "Male",
            "2000-01-03T10:15:30+01:00[Europe/Paris]",
            "City Name"
    );

    public ClientRequestDto clientRequestDto = new ClientRequestDto(
            "User name",
            "Male",
            "2000-01-03T10:15:30+01:00[Europe/Paris]",
            "City Name"
    );

    @Test
    public void shouldSaveClientRequestAndReturnClientResponse() {
        Client savedClient = clientRequestDto.toClient();
        savedClient.setId("5e7a1395ebc2df4b6c8f94da");
        when(clientRepository.save(clientRequestDto.toClient())).thenReturn(savedClient);

        Assertions.assertThat(clientService.saveClient(clientRequestDto))
                .isExactlyInstanceOf(ClientResponseDto.class);
        Assertions.assertThat(clientService.saveClient(clientRequestDto).getId())
                .isEqualTo("5e7a1395ebc2df4b6c8f94da");
        Assertions.assertThat(clientService.saveClient(clientRequestDto).getAge())
                .isGreaterThanOrEqualTo(20);
    }

    @Test
    public void shouldReturnListOfClientResponse() {
        String name = "User";

        when(clientRepository.findAllByCompleteNameContaining(name)).thenReturn(Collections.emptyList());
        Assertions.assertThat(clientService.getClientByName(name).size()).isEqualTo(0);

        List<Client> clientList = new ArrayList<>();
        clientList.add(client.toClient());

        when(clientRepository.findAllByCompleteNameContaining(name)).thenReturn(clientList);
        Assertions.assertThat(clientService.getClientByName(name).size()).isEqualTo(1);
    }

    @Test
    public void shouldReturnClientResponseWhenProvidingAnId() {
        String testId = client.getId();
        when(clientRepository.findById(testId)).thenReturn(Optional.of(client));
        Assertions.assertThat(clientService.getClientById(testId)).isExactlyInstanceOf(ClientResponseDto.class);
        Assertions.assertThat(clientService.getClientById(testId).getId()).isEqualTo(testId);
    }

    @Test
    public void shouldRemoveClientAndReturnNothing() {
        String testId = client.getId();
        doNothing().when(clientRepository).deleteById(testId);
        clientService.removeClient(testId);
        verify(clientRepository, times(1)).deleteById(testId);
    }

    @Test
    public void shouldChangeClientName() {
        String newName = "New User Name";
        String testId = client.getId();
        Client newClient = client;
        newClient.setCompleteName("New User Name");

        when(clientRepository.findById(client.getId())).thenReturn(Optional.of(client));
        when(clientRepository.save(client)).thenReturn(newClient);

        Assertions.assertThat(clientService.changeClientName(testId, newName).getCompleteName()).isEqualTo("New User Name");
    }

}
