package homework13.services;

import homework13.dao.ClientStatusDao;
import homework13.dto.ClientStatusDto;
import homework13.entity.ClientStatus;
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
class ClientStatusServiceTest {

    @Mock
    private ClientStatusDao clientStatusDao;

    private ClientStatusService clientStatusService;

    @BeforeEach
    public void setUp() {
        clientStatusService = new ClientStatusService(clientStatusDao);
    }

    @Test
    public void shouldMethodFindAllNeededStatuses() {
        ClientStatus clientStatus = new ClientStatus();
        clientStatus.setClientId(1);
        clientStatus.setStatusId(1);

        when(clientStatusDao.findAllClientStatuses()).thenReturn(Collections.singletonList(clientStatus));

        List<ClientStatusDto> actualResult = clientStatusService.findAllClientsStatuses();

        assertEquals(1, actualResult.size());
        assertEquals(1, actualResult.get(0).getClientId());
        assertEquals(1, actualResult.get(0).getStatusId());

    }
}
