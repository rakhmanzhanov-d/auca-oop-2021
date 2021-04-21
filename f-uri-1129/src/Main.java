import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int tests;
        while ((tests = inp.nextInt()) != 0) {
            for (int i = 0; i < tests; i++) {
                int cnt = 0, position = 0, num;
                for (int j = 0; j < 5; j++) {
                    num = inp.nextInt();
                    if (num <= 127) {
                        cnt++;
                        position = j;
                    }
                }
                if (cnt == 0 || cnt > 1) {
                    System.out.println("*");
                } else if (cnt == 1) {
                    System.out.println((char) ('A' + position));
                }
            }
        }
    }
}
