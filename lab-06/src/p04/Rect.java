package p04;

// subclass of class Figure
public class Rect extends Figure {
    private int w;
    private int h;

    public Rect(int x, int y, int w, int h) {
        super(x, y);
        if (w < 0) {
            throw new IllegalArgumentException("Rectangle's Width < 0!?");
        }
        if (h < 0) {
            throw new IllegalArgumentException("Rectangle's Height < 0!?");
        }

        this.w = w;
        this.h = h;

    }

    @Override
    public boolean contains(int xClick, int yClick) {
        return x <= xClick && x + w >= xClick && y <= yClick && y + h >= yClick;
    }

    @Override
    public String toString() {
        return String.format("Rect(%d, %d, %d, %d)", x, y, w, h);
    }

}
