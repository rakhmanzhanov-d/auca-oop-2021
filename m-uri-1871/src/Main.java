import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int a = inp.nextInt();
        int b = inp.nextInt();

        while (a != 0 && b != 0) {
            int c = a + b;
            String sum = Integer.toString(c);
            for (int i = 0; i < sum.length(); i++) {
                if (sum.charAt(i) != '0') {
                    System.out.print(Integer.parseInt(String.valueOf(sum.charAt(i))));
                }
            }
            System.out.println();

            a = inp.nextInt();
            b = inp.nextInt();
        }
    }
}
