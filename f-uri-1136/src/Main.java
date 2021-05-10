import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int n, m;

        while ((n = inp.nextInt()) != 0 && (m = inp.nextInt()) != 0) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int x = inp.nextInt();
                list.add(x);
            }

            System.out.println(possible(n, list));
        }
    }

    private static String possible(int n, ArrayList<Integer> list) {
        int length = list.size();
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                set.add(Math.abs(list.get(i) - list.get(j)));
            }
        }


        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                return "N";
            }
        }
        return "Y";
    }
}
