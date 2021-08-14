package homework12.dao;

import homework12.database.Database;
import homework12.entity.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*2. Создать сервисы для своих сущностей: ClientDao, StatusDao, AccountDao, у каждого из которых реализовать CRUD методы*/

public class AccountDao {

    private static final String INSERT = "INSERT INTO account (client_id, number, value) VALUES (?, ?, ?)";
    public static final String ACCOUNTS = "SELECT * FROM account";
    private static final String DELETE_ACCOUNT= "DELETE from account WHERE id=?";
    private static final String UPDATE = "UPDATE account SET client_id=?, number=?, value=? WHERE id=?";
    private static final String SEARCH_ACCOUNT_BY_VALUE = "SELECT * from account where value>?";
    private static final String ACCOUNT_BY_ID = "SELECT * FROM account WHERE id=?";


    /*Получение списка*/

    public List<Account> findAllAccounts() {

        List<Account> resultList = new ArrayList<>();

        try {

            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(ACCOUNTS);

            while (resultSet.next()) {
                Account account = new Account();
                account.setId(resultSet.getInt("id"));
                account.setClientId(resultSet.getInt("client_id"));
                account.setNumber(resultSet.getString("number"));
                account.setValue(resultSet.getDouble("value"));

                resultList.add(account);
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return resultList;
    }

    /*Сохранение*/

    public void save(Account account) {

        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT)) {
            statement.setInt(1, account.getClientId());
            statement.setString(2, account.getNumber());
            statement.setDouble(3, account.getValue());
            statement.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    /*Удаление*/

    public void delete(Integer id) {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_ACCOUNT)) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    /*Обновление*/

    public void update(Account account) {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setInt(1, account.getClientId());
            statement.setString(2, account.getNumber());
            statement.setDouble(3, account.getValue());
            statement.setInt(4, account.getId());
            statement.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    /*5. Добавить метод для получения number из Account, где value > переданного значения;*/

    public List<String> searchAccountByValue (Double value) {

        List<String> resultList = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(SEARCH_ACCOUNT_BY_VALUE)) {
            statement.setDouble(1, value);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                resultList.add(resultSet.getString("value"));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return resultList;
    }

    /*Additional method to make Update method work*/

    public Account findById(Integer id) {

        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(ACCOUNT_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Account account = new Account();
                account.setId(resultSet.getInt("id"));
                account.setClientId(resultSet.getInt("client_id"));
                account.setNumber(resultSet.getString("number"));
                account.setValue(resultSet.getDouble("value"));

                return account;
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return null;
    }

}
