package p03;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        ArrayList<Figure> figures = Utils.createFigure();

        while (true) {
            System.out.print("x: ");
            int xClick = inp.nextInt();
            System.out.print("y: ");
            int yClick = inp.nextInt();

            if (xClick == -1 && yClick == -1) break;

            for (Figure f : figures) {
                // polymorphism
                // dynamic finding
                if (f.contains(xClick, yClick)) {
                    System.out.println(f);
                }
            }
        }
    }
}
