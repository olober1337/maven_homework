package homework13.services;

import homework13.dao.StatusDao;
import homework13.dto.StatusDto;
import homework13.entity.Status;

import java.util.ArrayList;
import java.util.List;

public class StatusService {

    private final StatusDao statusDao;

    public StatusService(StatusDao statusDao) {
        this.statusDao = statusDao;
    }

    public List<StatusDto> findAllStatuses() {

        List<Status> statuses = statusDao.findAllStatuses();
        List<StatusDto> result = new ArrayList<>();

        for (Status status: statuses) {
            StatusDto dto = new StatusDto();
            dto.setAlias(status.getAlias());
            dto.setDescription(status.getDescription());
            result.add(dto);
        }

        return result;
    }
}
