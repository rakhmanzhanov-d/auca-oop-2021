import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int n, m;
        while (inp.hasNextInt()) {
            n = inp.nextInt();
            m = inp.nextInt();
            int cnt = 0;

            for (int i = n; i <= m; i++) {
                Set<Character> set = new HashSet<>();
                String num = Integer.toString(i);
                int length = num.length();

                for (int j = 0; j < length; j++) {
                    set.add(num.charAt(j));
                }
                if (set.size() == length) {
                    cnt++;
                }
            }

            System.out.println(cnt);
        }
    }
}
