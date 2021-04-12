import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        while (true) {
            int x1 = inp.nextInt();
            int y1 = inp.nextInt();
            int x2 = inp.nextInt();
            int y2 = inp.nextInt();

            if (x1 == 0 && y1 == 0 && x2 == 0 && y2 == 0) {
                break;
            }

            if (x1 == x2 && y1 == y2) {
                System.out.println(0);
            } else if ((x2 - x1) == -(y2 - y1) || -(x2 - x1) == y2 - y1 || -(x2 - x1) == (y2 - y1) || (x2 - x1) == (y2 - y1)) {
                System.out.println(1);
            } else if (x1 == x2 || y1 == y2) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }
        }
    }
}
