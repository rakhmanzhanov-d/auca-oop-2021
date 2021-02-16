import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int test = inp.nextInt();
        String alpabet = "abcdefghigklmnopqrstuvwxyz";

        inp.nextLine();
        for (int t = 0; t < test; t++) {
            char[] arr = alpabet.toCharArray();
            String s = inp.nextLine();
            int cnt = 0;
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < alpabet.length(); j++) {
                    if (arr[j] == s.charAt(i)) {
                        arr[j] = '*';
                        cnt++;
                    }
                }
            }
            if (cnt >= 26) {
                System.out.println("frase completa");
            } else if (cnt >= 13) {
                System.out.println("frase quase completa");
            } else {
                System.out.println("frase mal elaborada");
            }
        }
    }
}
