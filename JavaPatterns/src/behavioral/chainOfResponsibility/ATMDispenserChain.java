package behavioral.chainOfResponsibility;

import java.util.Scanner;

/**
 * Created by Marina on 02.01.2017.
 */
public class ATMDispenserChain {
    private DispenseChain c1;
    public ATMDispenserChain(){
        this.c1 = new Dollar50Dispenser();
        DispenseChain c2 = new Dollar20Dispenser();
        DispenseChain c3 = new Dollar10Dispenser();

        c1.setNextChain(c2);
        c2.setNextChain(c3);
    }

    public static void main(String[] args) {
        ATMDispenserChain atmDispenser = new ATMDispenserChain();

        while (true) {
            int amount = 0;
            System.out.println("Enter amount to dispense");
            Scanner input = new Scanner(System.in);
            amount = input.nextInt();
            if (amount % 10 != 0) {
                System.out.println("Amount should be in multiple of 10s.");
                return;
            }

            atmDispenser.c1.dispense(new Currency(amount));
        }
    }

}
