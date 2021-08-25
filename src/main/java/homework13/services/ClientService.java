package homework13.services;

import homework13.dao.ClientDao;
import homework13.dto.ClientDto;
import homework13.entity.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientService {

    private final ClientDao clientDao;

    public ClientService(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public List<ClientDto> findAllCustomers() {

        List<Client> clients = clientDao.findAllCustomers();
        List<ClientDto> result = new ArrayList<>();

        for (Client client: clients) {
            ClientDto dto = new ClientDto();
            dto.setName(client.getName());
            dto.setEmail(client.getEmail());
            dto.setPhone(client.getPhone());
            dto.setAbout(client.getAbout());
            dto.setAge(client.getAge());
            result.add(dto);
        }

        return result;
    }
}
