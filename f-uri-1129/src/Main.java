import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int tests, a, b, c, d, e;
        while ((tests = inp.nextInt()) != 0) {
            for (int i = 0; i < tests; i++) {
                int cnt = 0, min = 255;
                String res = "";
                a = inp.nextInt();
                b = inp.nextInt();
                c = inp.nextInt();
                d = inp.nextInt();
                e = inp.nextInt();
                if (a <= 127) {
                    cnt++;
                    if (min >= a) {
                        min = a;
                        res = "A";
                    }
                }
                if (b <= 127) {
                    cnt++;
                    if (min >= b) {
                        min = b;
                        res = "B";
                    }
                }
                if (c <= 127) {
                    cnt++;
                    if (min >= c) {
                        min = c;
                        res = "C";
                    }
                }
                if (d <= 127) {
                    cnt++;
                    if (min >= d) {
                        min = d;
                        res = "D";
                    }
                }
                if (e <= 127) {
                    cnt++;
                    if (min >= e) {
                        min = e;
                        res = "E";
                    }
                }
                if (cnt > 1) {
                    System.out.println("*");
                } else {
                    System.out.println(res);
                }
            }
        }
    }
}
