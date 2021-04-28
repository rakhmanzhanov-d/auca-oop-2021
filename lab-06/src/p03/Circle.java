package p03;

// subclass of class Figure
public class Circle extends Figure {
    private int r;


    public Circle(int x, int y, int r) {
        super(x, y);
        if (r < 0) {
            throw new IllegalArgumentException("Radius < 0");
        }

        this.r = r;


    }

    @Override
    public String toString() {
        return String.format("Circle(%d, %d, %d)", x, y, r);
    }

    @Override
    public boolean contains(int xClick, int yClick) {
        int dx = xClick - x;
        int dy = yClick - y;
        return r * r >= dx * dx + dy * dy;
    }
}
