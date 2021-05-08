import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int a, b;
        while ((a = inp.nextInt()) != 0 && (b = inp.nextInt()) != 0) {
            int cnt = 0;
            Set<Integer> m1 = new HashSet<>();
            Set<Integer> m2 = new HashSet<>();

            // 1 - input
            for (int i = 0; i < a; i++) {
                int x = inp.nextInt();
                m1.add(x);
            }

            // 2 - input
            for (int i = 0; i < b; i++) {
                int x = inp.nextInt();
                m2.add(x);
            }

            int error = m1.size() + m2.size();
            cnt = Math.min(m1.size(), m2.size());

            m1.addAll(m2);
            error -= m1.size();

            System.out.println(cnt - error);
        }
    }
}
