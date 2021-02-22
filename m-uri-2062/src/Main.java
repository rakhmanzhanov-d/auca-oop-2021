import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        while (inp.hasNextInt()) {
            int n = inp.nextInt();
            String uri = "URI";
            String obi = "OBI";
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = inp.next();
                if (arr[i].length() == 3 && arr[i].startsWith("UR")) {
                    arr[i] = uri;
                } else if (arr[i].length() == 3 && arr[i].startsWith("OB")) {
                    arr[i] = obi;
                }
            }
            for (int i = 0; i < n; i++) {
                String space = " ";
                if (i == n - 1) {
                    space = "\n";
                }
                System.out.print(arr[i] + space);
            }
        }
    }
}
