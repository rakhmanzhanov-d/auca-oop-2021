import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        while (inp.hasNextInt()) {
            boolean isValid = false;
            double x = inp.nextDouble();
            double n = Math.pow(x, 1f / 2);
            for (double i = 0; i <= n + 1; i++) {
                for (int j = 0; j <= n; j++) {
                    if (i * i + j * j == x) {
                        isValid = true;
                    }
                }
            }

            System.out.println(isValid ? "YES" : "NO");
        }
    }
}
