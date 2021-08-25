package homework13.services;

import homework13.dao.ClientDao;
import homework13.dao.ClientStatusDao;
import homework13.dto.ClientStatusDto;
import homework13.entity.ClientStatus;

import java.util.ArrayList;
import java.util.List;

public class ClientStatusService {

    private final ClientStatusDao clientStatusDao;

    public ClientStatusService(ClientStatusDao clientStatusDao){
        this.clientStatusDao = clientStatusDao;
    }

    public List<ClientStatusDto> findAllClientsStatuses(){
        List<ClientStatus> clientStatuses = clientStatusDao.findAllClientStatuses();
        List<ClientStatusDto> result = new ArrayList<>();

        for (ClientStatus clientStatus: clientStatuses){
            ClientStatusDto dto = new ClientStatusDto();
            dto.setClientId(clientStatus.getClientId());
            dto.setStatusId(clientStatus.getStatusId());

            result.add(dto);
        }
        return result;
    }
}
