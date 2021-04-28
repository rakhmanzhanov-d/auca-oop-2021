package p05;


import java.awt.*;
import java.util.ArrayList;

public class Utils extends Figure {

    public Utils(int x, int y) {
        super(x, y);
    }

    public static ArrayList<Figure> createFigure() {
        ArrayList<Figure> figures = new ArrayList<>();
        figures.add(new Rect(0, 0, 10, 10));
        figures.add(new Circle(100, 200, 50));
        figures.add(new Cross(200, 200, 100, 100));
        return figures;
    }

    @Override
    public boolean contains(int x, int y) {
        return false;
    }

    @Override
    public void draw(Graphics g) {

    }
}
