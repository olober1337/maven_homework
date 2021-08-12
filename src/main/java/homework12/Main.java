package homework12;

import homework12.dao.AccountDao;
import homework12.dao.ClientDao;
import homework12.dao.StatusDao;
import homework12.entity.Account;
import homework12.entity.Client;
import homework12.entity.ClientStatus;
import homework12.entity.Status;

public class Main {

    public static void main(String[] args) {

        ClientDao clientDao = new ClientDao();
        checkClientDao(clientDao);
        AccountDao accountDao = new AccountDao();
        checkAccountDao(accountDao);
        StatusDao statusDao = new StatusDao();
        checkStatusDao(statusDao);

    }

    public static void checkClientDao (ClientDao clientDao) {

        /*Find all customers*/

        System.out.println("Here are all the customers: ");
        for (Client clients: clientDao.findAllCustomers()) {
            System.out.println(clients);
        }

        /*Insert customer*/

        Client client = new Client();

        client.setName("Vadym");
        client.setEmail("vadym@test.com");
        client.setPhone(380951111111L);
        client.setAbout("Hello my name is");
        client.setAge(25);
        clientDao.save(client);

        System.out.println("Clients list after adding client : ");
        System.out.println(clientDao.findAllCustomers());

        /*Update customer*/

        Client newClient = clientDao.findById(7);
        newClient.setAge(1);
        clientDao.update(newClient);
        System.out.println("Clients list after updating client : " + newClient);

        /*Delete customer*/

        System.out.println("Clients list after deleting client : ");
        clientDao.delete(8);
        System.out.println(clientDao.findAllCustomers());

        /*Search customers by phone*/

        System.out.println(clientDao.searchClientByNumber(380958089090L));

        /*Find customers where ID equals Account ID*/

        System.out.println("ID = Account ID method : ");
        for (Client clients: clientDao.findWhereClientIdIsEqualsAccountId()) {
            System.out.println(clients);
        }

        /*Find customers where age is more than 18*/

        System.out.println("Age more than eighteen method : ");
        for (ClientStatus clientStatuses: clientDao.clientStatusWithAgeMoreThanEighteen()) {
            System.out.println(clientStatuses);
        }
    }

    public static void checkAccountDao (AccountDao accountDao) {

        /*Find all accounts*/

        System.out.println("Here are all the accounts : ");
        for (Account accounts: accountDao.findAllAccounts()) {
            System.out.println(accounts);
        }

        /*Insert account*/

        Account account = new Account();

        System.out.println("Accounts after inserting new account : ");
        account.setClientId(3);
        account.setNumber("62");
        account.setValue(1020.4);
        accountDao.save(account);
        System.out.println(accountDao.findAllAccounts());

        /*Delete account*/

        System.out.println("Delete Account method : ");
        accountDao.delete(4);
        System.out.println(accountDao.findAllAccounts());

        /*Update customer*/

        Account account1 = accountDao.findById(5);
        System.out.println("Update Account method check : ");
        account1.setValue(2545.47);
        accountDao.update(account1);
        System.out.println(account1);

        /*Search accounts where value is more than inserted*/

        System.out.println("Value more than entered : ");
        for (String value : accountDao.searchAccountByValue(1010.10)) {
            System.out.println(value);
        }
    }

    public static void checkStatusDao (StatusDao statusDao) {

        /*Find all accounts*/

        System.out.println("Here are all the statuses : ");
        for (Status statuses: statusDao.findAllStatuses()) {
            System.out.println(statuses);
        }

        /*Insert status*/

        Status status = new Status();
        System.out.println("Statuses after inserting new status : ");
        status.setAlias("VIP PREMIUM");
        status.setDescription("Super mega vip premium access to software");
        statusDao.save(status);
        System.out.println(statusDao.findAllStatuses());

        /*Delete status*/

        System.out.println("Delete Status method : ");
        statusDao.delete(1);
        System.out.println(statusDao.findAllStatuses());

        /*Update status*/

        Status status1 = statusDao.findById(5);
        System.out.println("Update Status method : ");
        status1.setDescription("Not so VIP and Mega Status");
        statusDao.update(status1);
        System.out.println(status1);

    }
}
