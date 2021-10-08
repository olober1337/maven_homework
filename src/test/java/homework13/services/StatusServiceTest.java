package homework13.services;

import homework13.dao.StatusDao;
import homework13.dto.StatusDto;
import homework13.entity.Status;
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
class StatusServiceTest{

    @Mock
    private StatusDao statusDao;

    private StatusService statusService;

    @BeforeEach
    public void setUp() {
        statusService = new StatusService(statusDao);
    }

    @Test
    public void shouldMethodFindAllNeededStatuses() {
        Status status = new Status();
        status.setId(1);
        status.setAlias("Alias");
        status.setDescription("Description");

        when(statusDao.findAllStatuses()).thenReturn(Collections.singletonList(status));

        List<StatusDto> actualResult = statusService.findAllStatuses();

        assertEquals(1, actualResult.size());
        assertEquals("Alias", actualResult.get(0).getAlias());
        assertEquals("Description", actualResult.get(0).getDescription());

    }
}