import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int test = inp.nextInt();

        for (int t = 0; t < test; t++) {
            int counter = 0;
            String a = inp.next();
            String b = inp.next();
            for (int i = 0; i < a.length(); i++) {
                int aChar = a.charAt(i);
                int bChar = b.charAt(i);
                if (bChar > aChar) {
                    counter += bChar - aChar;
                } else if (bChar < aChar){
                    counter += 122 - aChar + bChar - 96;
                }
            }
            System.out.println(counter);
        }

    }
}
