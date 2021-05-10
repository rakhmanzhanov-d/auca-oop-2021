import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int n, k;

        while ((n = inp.nextInt()) != 0 && (k = inp.nextInt()) != 0) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            int cnt = 0;

            for (int i = 0; i < n; i++) {
                int x = inp.nextInt();
                if (map.containsKey(x)) {
                    Integer value = map.get(x);
                    map.put(x, ++value);
                } else {
                    map.put(x, 1);
                }
            }

            for (Map.Entry<Integer, Integer> el : map.entrySet()) {
                if (el.getValue() >= k) {
                    cnt++;
                }
            }

            System.out.println(cnt);
        }

    }
}
