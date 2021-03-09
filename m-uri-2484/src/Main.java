import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        while (inp.hasNext()) {
            String word = inp.next();
            char[] arr = word.toCharArray();
            int start = 0;
            int end = arr.length - 1;
            for (int i = 0; i < arr.length; i++) {
                String space = " ";
                for (int k = 0; k < start; k++) {
                    System.out.print(" ");
                }

                for (int k = 0; k <= end; k++) {
                    if (k == end) {
                        space = "\n";
                    }
                    System.out.print(arr[k] + space);
                }
                start++;
                end--;
            }
            System.out.println();
        }
    }
}
