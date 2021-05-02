import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        boolean isCompatible = true;
        int[] arr1 = new int[5];
        int[] arr2 = new int[5];

        for (int i = 0; i < 5; i++) {
            int x = inp.nextInt();
            arr1[i] = x;
        }

        for (int i = 0; i < 5; i++) {
            int x = inp.nextInt();
            arr2[i] = x;
        }

        for (int i = 0; i < 5; i++) {
            if (arr1[i] == arr2[i]) {
                isCompatible = false;
            }
        }

        System.out.println(isCompatible ? "Y" : "N");

    }
}
