import java.util.Scanner;
//////////////////////////////
//   DANCING SENTENCE
//////////////////////////////

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        for (int l = 0; l < 5; l++) {
            StringBuilder word = new StringBuilder(readLine(inp));
            if (!word.toString().isEmpty() && word.length() >= 1 && word.length() <= 50 || word.toString().equals(" ")) {
                int trigger = 1;
                String[] arr = word.toString().split(" ");

                for (int i = 0; i < arr.length; i++) {
                    StringBuilder newWord = new StringBuilder(arr[i]);
                    for (int t = 0; t < arr[i].length(); t++) {
                        char c = arr[i].charAt(t);
                        if (trigger == 1) {
                            trigger--;
                            if (c > 90) {
                                c = (char) (c - 32);
                            }
                        } else {
                            trigger++;
                            if (c < 91) {
                                c = (char) (c + 32);
                            }
                        }
                        newWord.setCharAt(t, c);
                    }
                    arr[i] = newWord.toString();
                }

                for (int i = 0; i < arr.length; i++) {
                    String space = " ";
                    if (i == arr.length - 1) {
                        space = "\n";
                    }
                    System.out.print(arr[i] + space);
                }
            }
        }
    }

    public static String readLine(Scanner inp) {
        String line = inp.nextLine();
        while (line.isEmpty())
            line = inp.nextLine();
        return line;
    }
}
