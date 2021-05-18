package MinesweeperGUI;

public class Smiley {
    private Main main;
    private Actionable action;
    private float x, y, w, h;

    public Smiley(Main main, Actionable action) {
        this.main = main;
        this.action = action;
        this.w = 50;
        this.h = 50;
        this.x = main.width / 2f - main.row / 2f;
        this.y = main.height / 2f - main.col * 20;
    }

    public void draw() {
        if (main.curState == 0) {
            main.image(main.imgLook, x, y, w, h);
        } else if (main.curState == 1) {
            main.image(main.imgWin, x, y, w, h);
        } else if (main.curState == -1) {
            main.image(main.imgFail, x, y, w, h);
        }
    }

    public boolean contains(int mouseX, int mouseY) {
        return x <= mouseX && mouseX < x + w && y <= mouseY && mouseY <= y + h;
    }

    public void performAction() {
        action.perform();
    }
}
