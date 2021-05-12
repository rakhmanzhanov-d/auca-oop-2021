package p05;

import java.awt.*;

public abstract class Figure {
    protected int x;
    protected int y;


    private boolean isSelected;

    public Figure(int x, int y) {
        this.x = x;
        this.y = y;
        this.isSelected = false;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public abstract boolean contains(int x, int y);

    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public abstract void draw(Graphics g);
}
