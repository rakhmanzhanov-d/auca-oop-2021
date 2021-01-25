import java.util.Scanner;
//////////////////////////////
//   FIT OR DON'T FIT ||
//////////////////////////////

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int n = inp.nextInt();
        inp.nextLine();
        for (int i = 0; i < n; i++) {
            String word1 = inp.next();
            String word2 = inp.next();
            int length = Math.min(word1.length(), word2.length());
            int test = 0;

            if (word1.length() >= word2.length()) {
                for (int t = 0, k = word1.length() - length; t < length; t++, k++) {
                    if (word1.charAt(k) == word2.charAt(t)) {
                        test++;
                    }
                }
            }

            if (test == length) {
                System.out.println("encaixa");
            } else {
                System.out.println("nao encaixa");
            }
        }
    }
}
