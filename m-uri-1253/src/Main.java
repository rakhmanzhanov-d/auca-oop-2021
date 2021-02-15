import java.util.Scanner;

//Accepted
public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int n = inp.nextInt();
        for (int i = 0; i < n; i++) {
            StringBuilder newWord = new StringBuilder(readLine(inp));
            int shift = inp.nextInt();

            for (int j = 0; j < newWord.length(); j++) {
                int code = newWord.charAt(j);
                char c;
                if (code >= 65 && code <= 90) {
                    if (code - shift < 65) {
                        c = (char) (91 - (65 - (code - shift)));
                    } else {
                        c = (char) (code - shift);
                    }
                    newWord.setCharAt(j, c);
                }
            }
            System.out.println(newWord.toString());
        }
    }

    public static String readLine(Scanner inp) {
        String line = inp.nextLine();
        while (line.isEmpty())
            line = inp.nextLine();
        return line;
    }
}
