package exersices;

import java.math.BigInteger;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter number: ");
        BigInteger n = inp.nextBigInteger();

        System.out.println("Factorial of " + n + " is " + factorial(n));
    }

    public static BigInteger factorial(BigInteger n) {
        if (n.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        } else {
            return n.multiply(factorial(n.subtract(BigInteger.ONE)));
        }
    }
}
