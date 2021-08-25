package homework13.services;

import homework13.dao.ClientDao;
import homework13.dto.ClientDto;
import homework13.entity.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientServiceTest{

    @Mock
    private ClientDao clientDao;

    private ClientService clientService;

    @BeforeEach
    public void setUp() {
        clientService = new ClientService(clientDao);
    }

    @Test
    public void shouldMethodFindAllSuitableClients() {
        Client client = new Client();
        client.setName("Name");
        client.setEmail("Email");
        client.setPhone(380951111111L);
        client.setAbout("About");
        client.setAge(1);

        when(clientDao.findAllCustomers()).thenReturn(Collections.singletonList(client));

        List<ClientDto> actualResult = clientService.findAllCustomers();

        assertEquals(1, actualResult.size());
        assertEquals("Name", actualResult.get(0).getName());
        assertEquals("Email", actualResult.get(0).getEmail());
        assertEquals(380951111111L, actualResult.get(0).getPhone());
        assertEquals("About", actualResult.get(0).getAbout());
        assertEquals(1, actualResult.get(0).getAge());

    }
}