package p04;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        ArrayList<Figure> figures = Utils.createFigure();

        while (true) {
            System.out.print("cmd: ");
            String line = inp.nextLine();
            if (line.equals("stop")) {
                break;
            } else if (line.equals("showAll")) {
                System.out.println(figures);
            } else if (line.equals("click")) {
                System.out.print("x: ");
                int x = inp.nextInt();
                System.out.print("y: ");
                int y = inp.nextInt();
                System.out.println();
                if (x == -1 && y == -1) break;

                for (Figure f : figures) {
                    // polymorphism
                    // dynamic finding
                    if (f.contains(x, y)) {
                        System.out.println(f);
                    }
                }
            } else if (line.equals("move")) {
                System.out.print("x1: ");
                int x1 = inp.nextInt();
                System.out.print("y1: ");
                int y1 = inp.nextInt();
                System.out.println();

                System.out.print("x2: ");
                int x2 = inp.nextInt();
                System.out.print("x2: ");
                int y2 = inp.nextInt();
                System.out.println();

                for (Figure f : figures) {
                    if (f.contains(x1, x2)) {
                        f.move(x2 - x1, y2 - y1);
                    }
                }
            } else if (line.equals("cross")) {
                System.out.print("x1: ");
                int x = inp.nextInt();
                System.out.print("y1: ");
                int y = inp.nextInt();

                for (Figure f : figures) {
                    // polymorphism
                    // dynamic finding
                    if (f.contains(x, y)) {
                        System.out.println(f);
                    }
                }
            }


        }
    }
}
