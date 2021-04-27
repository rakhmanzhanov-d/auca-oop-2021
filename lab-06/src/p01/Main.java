package p01;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        ArrayList<Rect> rectangles = new ArrayList<>();

        rectangles.add(new Rect(100, 100, 200, 100));
        rectangles.add(new Rect(600, 100, 50, 50));
        rectangles.add(new Rect(300, 500, 100, 100));

        while (true) {
            System.out.print("x: ");
            int xClick = inp.nextInt();

            System.out.print("y: ");
            int yClick = inp.nextInt();

            if (xClick == -1 && yClick == -1) break;

            for (Rect r : rectangles) {
                if (r.contains(xClick, yClick)) {
                    System.out.println(r);
                }
            }
        }

    }
}
