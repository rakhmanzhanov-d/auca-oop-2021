import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        String first = null, second;
        while (inp.hasNext()) {
            first = inp.nextLine();
            while (inp.hasNext()) {
                second = inp.nextLine();
                if (first.length() >= second.length()) {
                    System.out.println(maxMatch(first, second, first.length()));
                } else {
                    System.out.println(maxMatch(second, first, second.length()));
                }
                break;
            }
        }
    }

    public static int maxMatch(String first, String second, int length) {
        int max = 0;
        for (int j = 0; j < second.length(); j++) {
            for (int i = 0; i < length; i++) {
                int temp = 0;
                for (int m = i, n = j; second.charAt(n) == first.charAt(m); m++, n++) {
                    temp++;
                    if (temp > max) {
                        max = temp;
                    }
                    if (n == second.length() - 1 || m == length - 1) {
                        break;
                    }
                }
            }
        }
        return max;
    }
}
