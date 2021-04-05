package exersices;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter numbers for computing GCD: ");
        int n = inp.nextInt();
        int m = inp.nextInt();

        System.out.printf("GCD(%d, %d) = %d", n, m, gcd(n, m));
    }

    private static int gcd(int n, int m) {
        if(n % m == 0){
            return m;
        }else{
            return gcd(m, n % m);
        }
    }
}
