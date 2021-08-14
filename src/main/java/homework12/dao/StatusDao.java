package homework12.dao;

import homework12.database.Database;
import homework12.entity.Status;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*2. Создать сервисы для своих сущностей: ClientDao, StatusDao, AccountDao, у каждого из которых реализовать CRUD методы*/

public class StatusDao {

    private static final String INSERT = "INSERT INTO statuses (alias, description) VALUES (?, ?)";
    public static final String STATUSES = "SELECT * FROM statuses";
    private static final String DELETE_STATUS = "DELETE from statuses WHERE id=?";
    private static final String UPDATE = "UPDATE statuses SET alias=?, description=? WHERE id=?";
    private static final String STATUS_BY_ID = "SELECT * FROM statuses WHERE id=?";

    /*Получение списка*/

    public List<Status> findAllStatuses() {

        List<Status> resultList = new ArrayList<>();

        try {

            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(STATUSES);

            while (resultSet.next()) {
                Status status = new Status();
                status.setId(resultSet.getInt("id"));
                status.setAlias(resultSet.getString("alias"));
                status.setDescription(resultSet.getString("description"));

                resultList.add(status);
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return resultList;
    }

    /*Сохранение*/

    public void save(Status status) {

        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT)) {
            statement.setString(1, status.getAlias());
            statement.setString(2, status.getDescription());
            statement.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    /*Удаление*/

    public void delete(Integer id) {

        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_STATUS)) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    /*Обновление*/

    public void update(Status status) {

        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setString(1, status.getAlias());
            statement.setString(2, status.getDescription());
            statement.setInt(3, status.getId());
            statement.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public Status findById(Integer id) {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(STATUS_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Status status = new Status();
                status.setId(resultSet.getInt("id"));
                status.setAlias(resultSet.getString("alias"));
                status.setDescription(resultSet.getString("description"));

                return status;
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return null;
    }
}
