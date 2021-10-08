package homework20.chainofresponsibility;

public interface DispenseChain {

    void setNextChain(DispenseChain nextChain);

    void dispense(VendingMachine vendingMachine);
}
