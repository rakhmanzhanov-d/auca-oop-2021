package MinesweeperGUI;

import processing.core.PImage;

public class ButtonCell {
    private Main main;
    private int row;
    private int col;
    private int c;
    private int r;
    private Actionable action;
    private float x, y, w, h;
    private PImage imgFlag;

    public ButtonCell(PImage imgFlag, int row, int col, int r, int c, Main main, Actionable action) {
        this.row = row;
        this.col = col;
        this.r = r;
        this.c = c;
        this.main = main;
        this.action = action;
        this.w = 25;
        this.h = 25;
        this.x = (main.width / 2f - row * w / 2f) + r * w;
        this.y = (main.height / 2f - col * h / 2f) + c * h;
        this.imgFlag = imgFlag;
    }

    public void draw() {
        main.strokeWeight(2);
        main.fill(255);
        main.rect(x, y, w, h);
        if (main.reveals[r][c]) {
            // 1. check if cur element is not flag
            if (!main.flags[r][c]) {
                main.strokeWeight(4);
                main.fill(200);
                main.rect(x, y, w, h);
                if (main.data.getCurValue(r, c) == 0) {
                    main.fill(0);
                    main.text(main.data.getCurValue(r, c), x + w / 2 - w / 6, y + h - 3);
                }
                if (main.data.getCurValue(r, c) == 1) {
                    main.fill(10, 16, 191);
                    main.text(main.data.getCurValue(r, c), x + w / 2 - w / 6, y + h - 3);
                }
                if (main.data.getCurValue(r, c) == 2) {
                    main.fill(255, 0, 13);
                    main.text(main.data.getCurValue(r, c), x + w / 2 - w / 6, y + h - 3);
                }
                if (main.data.getCurValue(r, c) == 3) {
                    main.fill(0, 133, 15);
                    main.text(main.data.getCurValue(r, c), x + w / 2 - w / 6, y + h - 3);
                }
            }
        }

        if (main.flags[r][c]) {
            main.fill(0);
            main.image(imgFlag, x, y, w, h);
        }

    }

    public void performAction() {
        action.perform();
    }

    public boolean contains(int mouseX, int mouseY) {
        return x <= mouseX && mouseX < x + w && y <= mouseY && mouseY <= y + h;
    }
}
