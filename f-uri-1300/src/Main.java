import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        while (inp.hasNextInt()) {
            int x = inp.nextInt();
            if (x % 6 == 0) {
                System.out.println("Y");
            } else {
                System.out.println("N");
            }
        }
    }
}
