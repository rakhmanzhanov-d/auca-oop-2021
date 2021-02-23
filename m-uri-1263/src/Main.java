import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        while (inp.hasNext()) {
            String word = inp.nextLine();
            String[] arrWords = word.split(" ");
            String[] arrLetters = new String[arrWords.length];
            int stopIndex = 0;
            int cnt = 0;
            int cntAlliteration = 0;

            for (int i = 0; i < arrWords.length; i++) {
                arrLetters[i] = String.valueOf(arrWords[i].toLowerCase().charAt(0));
            }
            for (int i = 0; i < arrLetters.length; i++) {
                if (i >= stopIndex) {
                    for (int k = i + 1; k < arrLetters.length; k++) {
                        if (!arrLetters[i].equals(arrLetters[k])) {
                            break;
                        } else {
                            cnt++;
                            stopIndex = k;
                        }
                    }
                }
                if (cnt > 0) {
                    cntAlliteration++;
                    cnt = 0;
                }
            }
            System.out.println(cntAlliteration);

        }
    }
}
