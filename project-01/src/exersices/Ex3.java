package exersices;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = inp.nextInt();

        System.out.printf("Number %dth sum of digits is: %d\n", n, sumOfDigits(n));
    }

    private static int sumOfDigits(int n) {
        if((n - n % 10) / 10 > 0){
            return n % 10 + sumOfDigits((n - n % 10) / 10);
        }else{
            return n;
        }
    }
}
