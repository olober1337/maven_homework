package homework4.entities;

public class Client {
    private String clientID;
    private String lastName;
    private String accountID;
    private Double sum;

    public Client() {
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientID='" + clientID + '\'' +
                ", lastName='" + lastName + '\'' +
                ", accountID='" + accountID + '\'' +
                ", sum=" + sum +
                '}';
    }
}
