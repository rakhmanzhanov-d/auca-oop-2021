package p05;

import java.awt.*;

public class Cross extends Figure {
    private Rect hRect;
    private Rect vRect;

    public Cross(int x, int y, int s1, int s2) {
        super(x, y);
        if (s1 < 1 || s2 < 1) {
            throw new IllegalArgumentException("Cross: Incorrect size");
        }

        hRect = new Rect(x - s1 / 2, y - s2 / 2, s1, s2);
        vRect = new Rect(x - s2 / 2, y - s1 / 2, s2, s1);
    }


    @Override
    public void move(int dx, int dy) {
        super.move(dx, dy);
        hRect.move(dx, dy);
        vRect.move(dx, dy);
    }

    @Override
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        hRect.setSelected(selected);
        vRect.setSelected(selected);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        hRect.draw(g);
        vRect.draw(g);
    }

    @Override
    public String toString() {
        return String.format("Cross(%s, %s)", hRect, vRect);
    }

    @Override
    public boolean contains(int xClick, int yClick) {
        return hRect.contains(xClick, yClick) || vRect.contains(xClick, yClick);
    }

}
