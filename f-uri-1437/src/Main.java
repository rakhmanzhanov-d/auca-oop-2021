import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        while (inp.hasNextInt()) {
            int curPosition = 0;
            int numOfChars = inp.nextInt();
            if (numOfChars == 0) {
                break;
            }
            inp.nextLine();

            String str = inp.nextLine();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'D') {
                    if (curPosition + 1 > 3) {
                        curPosition = 0;
                    } else {
                        curPosition++;
                    }
                } else if (str.charAt(i) == 'E') {
                    if (curPosition - 1 < 0) {
                        curPosition = 3;
                    } else {
                        curPosition--;
                    }
                }
            }

            switch (curPosition) {
                case 0:
                    System.out.println("N");
                    break;
                case 1:
                    System.out.println("L");
                    break;
                case 2:
                    System.out.println("S");
                    break;
                case 3:
                    System.out.println("O");
                    break;
            }
        }
    }
}
