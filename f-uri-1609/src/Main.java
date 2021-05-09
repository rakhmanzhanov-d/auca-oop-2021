import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        int n = inp.nextInt();
        for (int t = 0; t < n; t++) {
            int m = inp.nextInt();
            Set<Integer> set = new HashSet<>();

            for (int i = 0; i < m; i++) {
                int x = inp.nextInt();
                set.add(x);
            }

            System.out.println(set.size());
        }
    }
}
