import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int n, l, ch, page = 1, charLengthPerLine = 0, lines = 1, cnt = 0, equals = 0;
        while (inp.hasNext()) {
            n = inp.nextInt();
            l = inp.nextInt();
            ch = inp.nextInt();

            for (int i = 1; i <= n; i++) {
                String word = inp.next();
                if (word.length() + charLengthPerLine < ch) {
                    charLengthPerLine += word.length() + 1;
                } else if (word.length() + charLengthPerLine == ch) {
                    if (word.length() == ch) {
                        lines++;
                    }
                    charLengthPerLine = 0;
                    lines++;
                } else if (word.length() + charLengthPerLine > ch) {
                    if (word.length() == ch) {
                        lines++;
                        charLengthPerLine = 0;
                    } else {
                        charLengthPerLine = word.length() + 1;
                    }
                    lines++;
                } else if (word.length() == ch) {
                    lines++;
                    charLengthPerLine = 0;
                }

                if (lines > l) {
                    page++;
                    lines = 1;
                }
            }

            System.out.println(page);
            lines = 1;
            charLengthPerLine = 0;
            page = 1;
        }
    }
}
