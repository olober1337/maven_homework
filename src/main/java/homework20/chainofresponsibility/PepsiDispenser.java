package homework20.chainofresponsibility;

public class PepsiDispenser implements DispenseChain{

    public DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(VendingMachine vendingMachine) {
        if(vendingMachine.getMoney() >= 10) {
            int number = vendingMachine.getMoney() / 10;
            int notification = vendingMachine.getMoney() % 10;
            System.out.println("Supplying" + number + "can of Pepsi!");
            if (notification != 0) this.chain.dispense(new VendingMachine(notification));
        }else{
            this.chain.dispense(vendingMachine);
        }
    }
}
