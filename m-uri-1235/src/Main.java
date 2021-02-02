import java.util.Scanner;
//////////////////////////////
//   INSIDE OUT
//////////////////////////////

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int n = inp.nextInt();
        String sentence = inp.nextLine();

        for (int k = 0; k < n; k++) {
            sentence = inp.nextLine();
            char[] arr = sentence.toCharArray();
            char[] arr1 = new char[arr.length / 2];
            char[] arr2 = new char[arr.length / 2];
            for (int i = (arr.length / 2) - 1, t = 0; i >= 0; i--, t++) {
                arr1[t] = arr[i];
                System.out.print(arr1[t]);
            }
            for (int i = arr.length - 1, t = 0; i >= arr.length / 2; i--, t++) {
                arr2[t] = arr[i];
                System.out.print(arr2[t]);
            }
            System.out.println();
        }
    }
}
