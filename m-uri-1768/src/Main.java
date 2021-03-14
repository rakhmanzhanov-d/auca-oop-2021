import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        while (inp.hasNextInt()) {
            int n = inp.nextInt();
            int middle = n / 2;

            for (int i = 1, k = middle; i <= n; i += 2, k--) {
                for (int l = 0; l < k; l++) {
                    System.out.print(" ");
                }
                for (int l = 0; l < i; l++) {
                    System.out.print("*");
                }
                System.out.println();
            }
            for (int i = 0; i < middle; i++) {
                System.out.print(" ");
            }
            System.out.println("*");
            for (int i = 0; i < middle - 1; i++) {
                System.out.print(" ");
            }
            System.out.print("*");
            System.out.print("*");
            System.out.println("*");

            System.out.println();
        }
    }
}
