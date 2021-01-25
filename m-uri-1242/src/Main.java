import java.util.Scanner;
//////////////////////////////
//   FIT OR DON'T FIT ||
//////////////////////////////

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int n = inp.nextInt();
        for (int i = 0; i < n; i++) {
            String word1 = inp.next();
            String word2 = inp.next();
            if (word1.length() > 0 && word1.length() < 1000 && word2.length() > 0 && word2.length() < 1000) {
                char[] arr1 = word1.toCharArray();
                char[] arr2 = word2.toCharArray();
                int lastIdMin = Math.min(word1.length(), word2.length()) - 1;
                int lastIdMax = Math.max(word1.length(), word2.length()) - 1;
                char lastDigit1, lastDigit2;

                if (word1.length() >= word2.length()) {
                    lastDigit1 = arr1[lastIdMax];
                    lastDigit2 = arr2[lastIdMin];
                } else {
                    lastDigit1 = arr1[lastIdMin];
                    lastDigit2 = arr2[lastIdMax];
                }

                if (lastDigit1 == lastDigit2) {
                    System.out.println("encaixa");
                } else {
                    System.out.println("nao encaixa");
                }
            }
        }
    }
}
