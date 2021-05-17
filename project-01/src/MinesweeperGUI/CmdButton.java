package MinesweeperGUI;
public class CmdButton {
    protected float x, y, w, h;
    protected String difficulty;
    protected Main main;
    protected boolean isPressed;
    private Actionable action;

    public CmdButton(float x, float y, float w, float h, String difficulty, Main main, Actionable action) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.difficulty = difficulty;
        this.main = main;
        this.isPressed = false;
        this.action = action;
    }

    public void draw() {
        main.fill(82.7f, 82.7f, 82.7f);
        main.rect(x, y, w, h);
        main.fill(8, 255, 8);
        main.textSize(25);
        main.text(difficulty, x + w / 6f, y + h / 2f);
    }

    public void performAction() {
        action.perform();
    }

    public boolean contains(int mouseX, int mouseY) {
        return x <= mouseX && mouseX < x + w && y <= mouseY && mouseY <= y + h;
    }
}
