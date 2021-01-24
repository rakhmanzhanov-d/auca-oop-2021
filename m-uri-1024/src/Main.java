import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int N = inp.nextInt();

        for (int i = 0; i < N; i++) {
            StringBuilder M = new StringBuilder(readLine(inp));

            for (int j = 0; j < M.length(); j++) {
                int code = M.charAt(j);
                if ((code >= 65 && code <= 90) || (code >= 97 && code <= 122)) {
                    char c = (char) (code + 3);
                    M.setCharAt(j, c);
                }
            }

            M.reverse();

            for (int j = M.length() / 2; j < M.length(); j++) {
                char c = (char) (M.charAt(j) - 1);
                M.setCharAt(j, c);
            }

            // Print
            System.out.println(M.toString());
        }
    }

    public static String readLine(Scanner inp) {
        String line = inp.nextLine();
        while (line.isEmpty())
            line = inp.nextLine();
        return line;
    }

}
