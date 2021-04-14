import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int tests = 0;
        boolean isFirst = true;
        boolean isSecond = false;
        while (inp.hasNext()) {
            if (isSecond) {
                isSecond = false;
            } else if (!isFirst) {
                System.out.println();
            }

            int males = 0, females = 0, numOfSameShoes = 0;
            tests++;

            int searchedShoeNumber = inp.nextInt();
            inp.nextLine();

            String line = inp.nextLine();
            String[] s = line.split(" ");
            for (int i = 0; i < s.length; i++) {
                if (Character.isDigit(s[i].charAt(0))) {
                    int num = Integer.parseInt(s[i]);
                    if (num == searchedShoeNumber) {
                        numOfSameShoes++;
                        if (s[i + 1].equals("F")) {
                            females++;
                        } else if (s[i + 1].equals("M")) {
                            males++;
                        }
                    }
                }
            }

            System.out.printf("Caso %d:\n", tests);
            System.out.printf("Pares Iguais: %d\n", numOfSameShoes);
            System.out.printf("F: %d\n", females);
            System.out.printf("M: %d\n", males);

            if (isFirst) {
                isFirst = false;
                isSecond = true;
            }
        }
    }
}
