import java.util.Scanner;

public class Main {

    static int remaining(int n, int k) {
        int r = 0;
        for (int i = 2; i <= n; i++) {
            r = (r + k) % i;
        }
        return r;
    }

    public static void main(String[] args) {

        Scanner inp = new Scanner(System.in);
        int tests = inp.nextInt();
        for (int t = 1; t <= tests; t++) {
            int a = inp.nextInt();
            int step = inp.nextInt();

            System.out.printf("Case %d: %d\n", t, remaining(a, step) + 1);
        }
    }
}
