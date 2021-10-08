package homework20.chainofresponsibility;

public class DrPepperDispenser implements DispenseChain{

    public DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(VendingMachine vendingMachine) {
        if(vendingMachine.getMoney() >= 40) {
            int number = vendingMachine.getMoney() / 40;
            int notification = vendingMachine.getMoney() % 40;
            System.out.println("Supplying" + number + "can of Dr.Pepper!");
            if (notification != 0) this.chain.dispense(new VendingMachine(notification));
        }else{
            this.chain.dispense(vendingMachine);
        }
    }
}
