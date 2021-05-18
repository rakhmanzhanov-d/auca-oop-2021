package help03;

public class ProcessingButton {
    private final float DARK_GRAY = 50;
    private final float LIGHT_GRAY = 100;
    private final float PRESSED_GRAY = 150;
    protected Main main;
    protected float x;
    protected float y;
    protected float w;
    protected float h;
    private boolean isPressed;
    private Actionable action;

    public ProcessingButton(Main main, float x, float y, float w, float h, Actionable action) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.isPressed = false;
        this.main = main;
        this.action = action;
    }

    public void draw() {
        float dw = main.width / 200f;
        float dh = main.width / 200f;
        float x2 = x + dw;
        float y2 = y + dh;

        if (isPressed || main.mousePressed && contains(main.mouseX, main.mouseY)) {
            main.fill(DARK_GRAY);
            main.rect(x, y, w, h);
            main.fill(PRESSED_GRAY);
            main.rect(x2, y2, w - 2 * dw, h - 2 * dh);
        } else {
            main.fill(DARK_GRAY);
            main.rect(x, y, w, h);
            main.fill(LIGHT_GRAY);
            main.rect(x2, y2, w - 2 * dw, h - 2 * dh);
        }
    }

    public boolean contains(float mouseX, float mouseY) {
        return x <= mouseX && mouseX < x + w && y <= mouseY && mouseY <= y + h;
    }


    public void performAction() {
        action.perform();
    }
}
