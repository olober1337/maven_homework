package homework13.dao;

import homework13.database.Database;
import homework13.entity.ClientStatus;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientStatusDao {

    private static final String SELECT_CLIENT_STATUSES = "SELECT *  FROM client_status";

    public List<ClientStatus> findAllClientStatuses() {
        List<ClientStatus> list = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_CLIENT_STATUSES) ) {

            while (resultSet.next()) {
                ClientStatus clientStatus = new ClientStatus();
                clientStatus.setClientId(resultSet.getInt("client_id"));
                clientStatus.setStatusId(resultSet.getInt("status_id"));
                list.add(clientStatus);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return list;
    }
}
