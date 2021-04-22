import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        while (inp.hasNextInt()) {
            int[] right = new int[31];
            int[] left = new int[31];
            String s;
            int size, res = 0;

            int n = inp.nextInt();

            for (int i = 0; i < n; i++) {
                size = inp.nextInt();
                s = inp.next();

                if (s.equals("D")) {
                    right[size - 30]++;
                } else if (s.equals("E")) {
                    left[size - 30]++;
                }
            }

            for (int i = 0; i < 31; i++) {
                res += Math.min(right[i], left[i]);
                right[i] = 0;
                left[i] = 0;
            }

            System.out.println(res);
        }
    }
}
