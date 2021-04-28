package p03;

import java.util.ArrayList;

public class Utils extends Figure {

    public Utils(int x, int y) {
        super(x, y);
    }

    public static ArrayList<Figure> createFigure() {
        ArrayList<Figure> figures = new ArrayList<>();
        figures.add(new Rect(0, 0, 10, 10));
        figures.add(new Circle(100, 200, 50));
        figures.add(new Rect(100, 500, 10, 10));
        figures.add(new Rect(650, 500, 10, 10));
        figures.add(new Rect(300, 500, 10, 10));
        figures.add(new Circle(100, 500, 10));
        figures.add(new Circle(650, 500, 10));
        figures.add(new Circle(300, 500, 10));
        return figures;
    }

    @Override
    public boolean contains(int x, int y) {
        return false;
    }
}
