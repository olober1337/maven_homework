package homework20.adapter;

public class AdapterTest {

    public static void main(String[] args) {

        Transaction money = new Money(new Account());
        money.startOfTransaction();
        money.resultOfTransaction();

    }
}
