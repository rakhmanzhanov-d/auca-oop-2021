import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int n;
        while ((n = inp.nextInt()) != 0) {
            int cntMary = 0, cntJohn = 0;
            for (int i = 0; i < n; i++) {
                int num = inp.nextInt();
                if (num == 0) {
                    cntMary++;
                } else {
                    cntJohn++;
                }
            }
            System.out.printf("Mary won %d times and John won %d times\n", cntMary, cntJohn);
        }
    }
}
