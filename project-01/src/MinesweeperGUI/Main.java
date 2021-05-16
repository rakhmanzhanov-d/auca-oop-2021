package MinesweeperGUI;

import processing.core.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main extends PApplet {
    int row, col, numMines;
    ArrayList<ButtonCell> buttons = new ArrayList<>();
    private ArrayList<CmdButton> cmdButtons = new ArrayList<>();
    Data data;
    protected int[][] mines;
    protected boolean[][] reveals;
    protected boolean[][] flags;
    private boolean firstClick;

    public void settings() {
        fullScreen();
    }

    public void setup() {
        // 1. Initial values
        row = 9;
        col = 9;
        numMines = 10;
        firstClick = true;


        // 2. Initialize data
        data = new Data(row, col, numMines, this);
        mines = data.getMinesData();
        reveals = data.getRevealsData();
        flags = data.getFlagsData();


        // 3. Add cmd buttons
        cmdButtons.add(new CmdButton(8 * (width / 10f), 4 * (height / 10f), width / 10f, height / 12f, "easy", this, () -> {
            row = 9;
            col = 9;
            numMines = 10;
            JOptionPane.showMessageDialog(null, "easy");
            System.out.println("Hello");
        }));
        cmdButtons.add(new CmdButton(8 * (width / 10f), 5 * (height / 10f), width / 10f, height / 12f, "medium", this, () -> {
            row = 16;
            col = 16;
            numMines = 40;
        }));
        cmdButtons.add(new CmdButton(8 * (width / 10f), 6 * (height / 10f), width / 10f, height / 12f, "expert", this, () -> {
            row = 30;
            col = 30;
            numMines = 99;
        }));


        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                System.out.println("Added");
                int finalR = r;
                int finalC = c;
                buttons.add(new ButtonCell(row, col, r, c, this, () -> {
                    // 1 Start GAME if it is first click
                    if (firstClick) {
                        firstClick = false;
                        do {
                            data.clearMines();
                            data.placeMines();
                        } while (data.calcNear(finalR, finalC) != 0);
                    }


                    JOptionPane.showMessageDialog(null, Arrays.deepToString(mines));
                    if (mouseButton == LEFT) {
                        // 1. reveal current grid cell
                        reveals[finalR][finalC] = true;

                    } else if (mouseButton == RIGHT) {
                        // 1. put flag on current cell
                        flags[finalR][finalC] = !flags[finalR][finalC];
                    }
                }));
            }
        }
    }

    public void draw() {
        background(0, 0, 0);

        for (CmdButton btn : cmdButtons) {
            btn.draw();
        }

        for (ButtonCell btn : buttons) {
            btn.draw();
        }
    }

    @Override
    public void mouseReleased() {
        for (ButtonCell btn : buttons) {
            if (btn.contains(mouseX, mouseY)) {
                btn.performAction();
            }
        }
    }

    public static void main(String[] args) {
        PApplet.main("MinesweeperGUI.Main");
    }

}