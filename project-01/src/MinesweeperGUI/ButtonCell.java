package MinesweeperGUI;
public class ButtonCell {
    private Main main;
    private int row;
    private int col;
    private int c;
    private int r;
    private Actionable action;
    private float x, y, w, h;

    public ButtonCell(int row, int col, int r, int c, Main main, Actionable action) {
        this.row = row;
        this.col = col;
        this.r = r;
        this.c = c;
        this.main = main;
        this.action = action;
        this.x = r * 40 + main.width / 3f;
        this.y = c * 40 + main.height / 3f;
        this.w = 40;
        this.h = 40;
    }

    public void draw() {
        main.strokeWeight(2);
        main.fill(180);
        main.rect(x, y, w, h);
        if (main.reveals[r][c]) {
            // 1. check if cur element is not flag
            if (!main.flags[r][c]) {
                main.strokeWeight(4);
                main.fill(200);
                main.rect(x, y, w, h);
            }
            // 2. Check if it mine , if(mine == true) -> break game
        }
        if (main.flags[r][c]) {
            main.fill(235, 64, 52);
            main.rect(x, y, w, h);
        }
    }

    public void performAction() {
        action.perform();
    }

    public boolean contains(int mouseX, int mouseY) {
        return x <= mouseX && mouseX < x + 40 && y <= mouseY && mouseY <= y + 40;
    }
}
