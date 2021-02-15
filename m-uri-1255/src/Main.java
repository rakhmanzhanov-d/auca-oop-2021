import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toLowerCase();

        int n = inp.nextInt();
        inp.nextLine();
        for (int i = 0; i < n; i++) {
            int[] counters = new int[alphabet.length()];
            String s = inp.nextLine();
            int maxCounter = 0;
            for (int j = 0; j < s.length(); j++) {
                char ch = Character.toLowerCase(s.charAt(j));
                int index = alphabet.indexOf(ch);
                if (index != -1) {
                    maxCounter = Math.max(++counters[index], maxCounter);
                }
            }
            for (int k = 0; k < counters.length; k++) {
                if (counters[k] == maxCounter) {
                    System.out.print(alphabet.charAt(k));
                }
            }
            System.out.println();
        }
    }
}
