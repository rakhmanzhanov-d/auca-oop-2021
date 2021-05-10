import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        int n = inp.nextInt();
        for (int t = 0; t < n; t++) {
            int[] arr = new int[10];

            for (int i = 0; i < 10; i++) {
                arr[i] = inp.nextInt();
            }


            System.out.println(arr[8] >= arr[0] && arr[8] <= arr[2] && arr[9] <= arr[7] && arr[9] >= arr[1] ? 1 : 0);
        }
    }
}
