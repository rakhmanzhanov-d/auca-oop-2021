import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        StringBuffer mainString = new StringBuffer();
        int cnt = 0;
        Set<String> data = new LinkedHashSet<>();
        int n = inp.nextInt();
        for (int i = 0; i <= n; ++i) {
            String str = inp.nextLine();
            data.add(str.trim());
        }

        System.out.println("Falta(m) " + (151 - data.size() + 1) + " pomekon(s).");
    }
}
