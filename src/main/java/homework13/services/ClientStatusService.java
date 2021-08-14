package homework13.services;

import homework13.dao.ClientDao;
import homework13.dto.ClientStatusDto;
import homework13.entity.ClientStatus;

import java.util.ArrayList;
import java.util.List;

public class ClientStatusService {

    private final ClientDao clientDao;

    public ClientStatusService(){
        clientDao = new ClientDao();
    }

    public List<ClientStatusDto> findAllClientsStatuses(){
        List<ClientStatus> clientStatuses = clientDao.findAllClientStatuses();
        List<ClientStatusDto> result = new ArrayList<>();

        for (ClientStatus clientStatus: clientStatuses){
            ClientStatusDto dto = new ClientStatusDto();
            dto.setName(clientStatus.getName());
            dto.setEmail(clientStatus.getEmail());
            dto.setAlias(clientStatus.getAlias());

            result.add(dto);
        }
        return result;
    }

}
