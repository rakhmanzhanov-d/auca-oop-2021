import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int n, m;

        while ((n = inp.nextInt()) != 0 && (m = inp.nextInt()) != 0) {
            int[] arr = new int[m];
            int cnt = 0;

            for (int i = 0; i < m; i++) {
                arr[i] = inp.nextInt();
            }

            int initPoint = arr[0];
            cnt = n - initPoint;
            for (int i = 0; i < m; i++) {
                if (arr[i] < initPoint) {
                    cnt += Math.abs(arr[i] - arr[i - 1]);
                }
                initPoint = arr[i];
            }

            System.out.println(cnt);
        }
    }
}



