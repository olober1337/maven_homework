package homework20.adapter;

public class Money implements Transaction{

    private Account account;

    public Money(Account account) {
        this.account = account;
    }

    @Override
    public void startOfTransaction() {
        System.out.println("The process has started!");
        this.account.startTransfer();
    }

    @Override
    public void resultOfTransaction() {
        System.out.println("Success!");
        this.account.successfulTransfer();
    }
}
