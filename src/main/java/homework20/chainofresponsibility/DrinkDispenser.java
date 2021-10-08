package homework20.chainofresponsibility;

import java.util.Scanner;

public class DrinkDispenser {

    private DispenseChain chain1;

    public DrinkDispenser() {

        this.chain1 = new PepsiDispenser();
        DispenseChain chain2 = new ColaDispenser();
        DispenseChain chain3 = new DrPepperDispenser();

        chain1.setNextChain(chain2);
        chain2.setNextChain(chain3);
    }

    public static void main(String[] args) {
        DrinkDispenser drinkDispenser = new DrinkDispenser();
        while (true) {
            int amount;
            System.out.println("Enter amount to order a drink");
            Scanner input = new Scanner(System.in);
            amount = input.nextInt();
            if (amount % 10 != 0) {
                System.out.println("Not enough money!");
                return;
            }

            drinkDispenser.chain1.dispense(new VendingMachine(amount));
        }
    }
}
