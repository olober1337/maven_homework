package homework13.dao;

import homework13.database.Database;
import homework13.entity.Client;
import homework13.entity.ClientStatus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*2. Создать сервисы для своих сущностей: ClientDao, StatusDao, AccountDao, у каждого из которых реализовать CRUD методы*/

public class ClientDao {

    private static final String INSERT = "INSERT INTO clients (name, email, phone, about, age) VALUES (?, ?, ?, ?, ?)";
    public static final String CUSTOMERS = "SELECT * FROM clients";
    private static final String DELETE_CUSTOMER = "DELETE from clients WHERE id=?";
    private static final String UPDATE = "UPDATE clients SET name=?, email=?, phone=?, about=?, age=? WHERE id=?";
    private static final String SEARCH_CUSTOMER_BY_PHONE = "SELECT * from clients where phone=?";
    private static final String CLIENT_ID_EQUALS_CLIENT_ACCOUNT_ID = "SELECT c.* FROM clients AS c INNER JOIN account AS a ON c.id = a.client_id";
    private static final String SEARCH_STATUSES_WITH_NAME_EMAIL_ALIAS = "SELECT c.name, c.email, c.phone, s.alias from clients AS c INNER JOIN client_status cs ON c.id = cs.client_id INNER JOIN statuses s ON cs.status_id = s.id WHERE c.age > 18";
    private static final String CUSTOMER_BY_ID = "SELECT * FROM clients WHERE id=?";
    private static final String CLIENTS_ID_EQUALS_ACCOUNT_ID =
            "SELECT * FROM clients INNER JOIN statuses ON (clients.id = statuses.id)";

    /*Получение списка*/

    public List<Client> findAllCustomers() {

        List<Client> resultList = new ArrayList<>();

        try {

            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(CUSTOMERS);

            while (resultSet.next()) {

                Client client = new Client();
                client.setId(resultSet.getInt("id"));
                client.setName(resultSet.getString("name"));
                client.setEmail(resultSet.getString("email"));
                client.setPhone(resultSet.getLong("phone"));
                client.setAbout(resultSet.getString("about"));
                client.setAge(resultSet.getInt("age"));

                resultList.add(client);
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return resultList;
    }

    /*Сохранение*/

    public void save(Client client) {

        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT)) {
            statement.setString(1, client.getName());
            statement.setString(2, client.getEmail());
            statement.setLong(3, client.getPhone());
            statement.setString(4, client.getAbout());
            statement.setInt(5, client.getAge());
            statement.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    /*Удаление*/

    public void delete(Integer id) {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMER)) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    /*Обновление*/

    public void update(Client client) {

        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setString(1, client.getName());
            statement.setString(2, client.getEmail());
            statement.setLong(3, client.getPhone());
            statement.setString(4, client.getAbout());
            statement.setInt(5, client.getAge());
            statement.setInt(6, client.getId());
            statement.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    /*4. Добавить метод для поиска Client по номеру телефона в соответствующий dao;*/

    public Client searchClientByNumber(Long phone) {

        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(SEARCH_CUSTOMER_BY_PHONE)) {
            statement.setLong(1, phone);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Client client = new Client();
                client.setId(resultSet.getInt("id"));
                client.setName(resultSet.getString("name"));
                client.setEmail(resultSet.getString("email"));
                client.setPhone(resultSet.getLong("phone"));
                client.setAbout(resultSet.getString("about"));
                client.setAge(resultSet.getInt("age"));

                return client;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return null;
    }

    /*6. Добавить метод для получения всех Clients где id клиент = client_id таблицы сущности Accounts;*/

    public List<Client> findWhereClientIdIsEqualsAccountId () {

        List<Client> list = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(CLIENT_ID_EQUALS_CLIENT_ACCOUNT_ID);

            while (resultSet.next()) {
                Client client = new Client();
                client.setId(resultSet.getInt("id"));
                client.setName(resultSet.getString("name"));
                client.setEmail(resultSet.getString("email"));
                client.setPhone(resultSet.getLong("phone"));
                client.setAbout(resultSet.getString("about"));
                client.setAge(resultSet.getInt("age"));
                list.add(client);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return list;
    }

    /*7. Добавить запрос для получения значений clients.name, clients.email, statuses.alias из таблицы клиентов
    (Clients) и из таблицы статусов(Statuses) используя join 3х таблиц и где возраст
    пользователей старше 18 лет. (Если возраста нет, надо что-то сделать чтобы был)*/

    public List<ClientStatus> clientStatusWithAgeMoreThanEighteen() {

        List<ClientStatus> resultList = new ArrayList<>();

        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SEARCH_STATUSES_WITH_NAME_EMAIL_ALIAS);

            while (resultSet.next()) {
                ClientStatus clientStatus = new ClientStatus();
                clientStatus.setName(resultSet.getString("name"));
                clientStatus.setEmail(resultSet.getString("email"));
                clientStatus.setAlias(resultSet.getString("alias"));

                resultList.add(clientStatus);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return resultList;
    }

    /*Additional method to make Update method work*/

    public Client findById(Integer id) {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(CUSTOMER_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Client client = new Client();
                client.setId(resultSet.getInt("id"));
                client.setName(resultSet.getString("name"));
                client.setEmail(resultSet.getString("email"));
                client.setPhone(resultSet.getLong("phone"));
                client.setAbout(resultSet.getString("about"));
                client.setAge(resultSet.getInt("age"));

                return client;
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return null;
    }

    public List<ClientStatus> findAllClientStatuses() {
        List<ClientStatus> resultList = new ArrayList<>();

        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(CLIENTS_ID_EQUALS_ACCOUNT_ID);

            while (resultSet.next()) {
                ClientStatus clientStatus = new ClientStatus();
                clientStatus.setName(resultSet.getString("name"));
                clientStatus.setEmail(resultSet.getString("email"));
                clientStatus.setAlias(resultSet.getString("alias"));

                resultList.add(clientStatus);
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return resultList;
    }

}