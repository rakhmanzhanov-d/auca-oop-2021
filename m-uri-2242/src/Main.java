import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toLowerCase();
        String vowels = "aeiou".toLowerCase();

        String lough = inp.next();
        StringBuilder onlyVowels = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i < lough.length(); i++) {
            char ch = Character.toLowerCase(lough.charAt(i));
            int indexInAlphabet = alphabet.indexOf(ch);
            int indexInVowels = vowels.indexOf(ch);
            if (indexInAlphabet != -1 && indexInVowels != -1) {
                onlyVowels.append(ch);
            }
        }
        if (onlyVowels.length() > 0) {
            for (int i = 0, t = onlyVowels.length() - 1; i < onlyVowels.length() / 2; i++, t--) {
                if (onlyVowels.charAt(i) == onlyVowels.charAt(t)) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt >= onlyVowels.length() / 2 ? "S" : "N");
    }
}
