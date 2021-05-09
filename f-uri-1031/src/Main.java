import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int n;
        while ((n = inp.nextInt()) != 0) {
            int cnt = 1;

            for (; ; ) {
                if (remaining(n, cnt) != 11) {
                    cnt++;
                } else break;
            }

            System.out.println(cnt);
        }
    }

    private static int remaining(int n, int cnt) {
        int remain = 0;
        for (int i = 1; i < n; i++) {
            remain = (remain + cnt) % i;
        }
        return remain;
    }
}
