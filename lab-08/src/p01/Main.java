package p01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        boolean continueReading = true;
        do {
            try {
                System.out.print("Enter an integer: ");
                int num = inp.nextInt();
                System.out.println("The number entered is " + num);
                continueReading = false;
            } catch (InputMismatchException ex) {
                System.out.println("Try again");
                System.out.println("Incorrect input: an integer is required");
                inp.nextLine(); // discard input (NEW)
            }
        } while (continueReading);

    }
}
