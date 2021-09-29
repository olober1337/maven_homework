package homework20.chainofresponsibility;

public class ColaDispenser implements DispenseChain{

    public DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(VendingMachine vendingMachine) {
        if(vendingMachine.getMoney() >= 20) {
            int number = vendingMachine.getMoney() / 20;
            int notification = vendingMachine.getMoney() % 20;
            System.out.println("Supplying" + number + "can of Cola!");
            if (notification != 0) this.chain.dispense(new VendingMachine(notification));
        }else{
            this.chain.dispense(vendingMachine);
        }
    }
}
