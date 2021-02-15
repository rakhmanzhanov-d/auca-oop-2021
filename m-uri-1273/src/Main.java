import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int n;
        while ((n = inp.nextInt()) != 0) {
            String[] arr = new String[n];
            int maxSize = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = inp.next();
                if (arr[i].length() > maxSize) {
                    maxSize = arr[i].length();
                }
            }

            for (int i = 0; i < arr.length; i++) {
                String temp = "";
                StringBuilder hehe = new StringBuilder(maxSize);
                if (arr[i].length() < maxSize) {
                    for (int k = 0; k < maxSize - arr[i].length(); k++) {
                        temp += " ";
                    }
                }
                temp += arr[i];
                arr[i] = temp;
                System.out.println(temp);
            }
            System.out.println();
        }
    }
}
