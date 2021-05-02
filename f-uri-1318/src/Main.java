import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int n, m;
        while ((n = inp.nextInt()) != 0 && (m = inp.nextInt()) != 0) {
            int res = 0;
            int[] arr = new int[m + 1];
            for (int i = 0; i < m; i++) {
                int x = inp.nextInt();
                if (n < x) {
                    res++;
                } else {
                    arr[x - 1]++;
                }
            }
            for (int i = 0; i <= m; i++) {
                if (arr[i] > 1) {
                    res++;
                }
            }
            System.out.println(res);
            System.out.println(Arrays.toString(arr));
        }
    }
}
