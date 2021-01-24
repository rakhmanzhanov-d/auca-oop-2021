import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int n = inp.nextInt();
        for (int i = 0; i < n; i++) {
            String word1 = inp.next();
            String word2 = inp.next();
            if((word1.length() >= 1 && word1.length() <= 50) && (word2.length() >= 1 && word2.length() <= 50)){
                StringBuilder newWord = new StringBuilder(word1 + word2);

                for (int t = 1, j = 0, k = 0; j < Math.min(word1.length(), word2.length()); t += 2, j++, k += 2) {
                    newWord.setCharAt(k, word1.charAt(j));
                    newWord.setCharAt(t, word2.charAt(j));
                }

                System.out.println(newWord.toString());
            }

        }
    }
}
