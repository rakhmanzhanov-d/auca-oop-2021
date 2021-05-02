import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        int n;

        while ((n = inp.nextInt()) != 0) {
            int x, max = 0;
            Map<Integer, Integer> m = new HashMap<>();
            SortedSet<Integer> s = new TreeSet<>();

            for (int i = 0; i < n; i++) {
                x = inp.nextInt();
                if (x > max) {
                    max = x;
                }
                s.add(x);
                m.put(x, i + 1);
            }

            s.remove(s.last());
            System.out.println(m.get(s.last()));
        }
    }
}
