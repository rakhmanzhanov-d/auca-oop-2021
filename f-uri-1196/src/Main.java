import java.util.Scanner;

public class Main {
    static final String ALPHABET = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./";
    static final char[] KEYBOARD = ALPHABET.toCharArray();

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        String line;
        char[] input;
        int index;
        while (inp.hasNextLine()) {
            line = inp.nextLine();
            input = line.toCharArray();
            for (char letter : input) {
                index = ALPHABET.indexOf(letter);
                System.out.print(index != -1 ? KEYBOARD[index - 1] : letter);
            }
            System.out.println();
        }
    }
}
