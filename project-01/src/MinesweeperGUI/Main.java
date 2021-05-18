package MinesweeperGUI;

import processing.core.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main extends PApplet {
    int row, col, numMines, numFlags, curState, minesLeft;
    ArrayList<ButtonCell> buttons = new ArrayList<>();
    private ArrayList<CmdButton> cmdButtons = new ArrayList<>();
    Data data;
    protected int[][] mines;
    protected boolean[][] reveals;
    protected boolean[][] flags;
    public boolean firstClick;
    protected PImage flag, imgLook, imgFail, imgWin;
    private Smiley image;
    private Counter counter;
    protected long startTime, stopTime;


    public void settings() {
        fullScreen();
    }

    public void setup() {
        // 1. Initial values
        row = 9;
        col = 9;
        numMines = 10;
        minesLeft = numMines;
        firstClick = true;
        flag = loadImage("flag.jpg");
        imgLook = loadImage("think.png");
        imgFail = loadImage("fail.png");
        imgWin = loadImage("win.png");
        curState = 0;

        // 2. Initialize game
        initGame(row, col, numMines);
    }

    public void draw() {
        background(0, 0, 0);

        for (CmdButton btn : cmdButtons) {
            btn.draw();
        }

        for (ButtonCell btn : buttons) {
            btn.draw();
        }

        image.draw();
        counter.draw();

    }

    @Override
    public void mouseReleased() {
        for (ButtonCell btn : buttons) {
            if (btn.contains(mouseX, mouseY)) {
                btn.performAction();
            }
        }

        for (CmdButton btn : cmdButtons) {
            if (btn.contains(mouseX, mouseY)) {
                btn.performAction();
            }
        }

        if (image.contains(mouseX, mouseY)) {
            image.performAction();
        }


    }

    public void initGame(int row, int col, int numMines) {
        // init values
        firstClick = true;
        this.row = row;
        this.col = col;
        this.numMines = numMines;
        minesLeft = numMines;
        curState = 0;
        data = new Data(row, col, numMines, this);
        mines = data.getMinesData();
        reveals = data.getRevealsData();
        flags = data.getFlagsData();
        startTime = 0;
        stopTime = 0;


        // clear and add cmd buttons
        cmdButtons = new ArrayList<>();
        cmdButtons.add(new CmdButton(width / 2f + row * 30 / 2f, height / 2f - 100, width / 10f, height / 16f, "easy", this, () -> {
            this.row = 9;
            this.col = 9;
            this.numMines = 10;
            initGame(this.row, this.col, this.numMines);
            System.out.println("RESTART EASY");
            firstClick = true;

        }));
        cmdButtons.add(new CmdButton(width / 2f + row * 30 / 2f, height / 2f, width / 10f, height / 16f, "medium", this, () -> {
            this.row = 16;
            this.col = 16;
            this.numMines = 40;
            initGame(this.row, this.col, this.numMines);
            System.out.println("RESTART MEDIUM");
            firstClick = true;
        }));
        cmdButtons.add(new CmdButton(width / 2f + row * 30 / 2f, height / 2f + 100, width / 10f, height / 16f, "expert", this, () -> {
            this.row = 30;
            this.col = 16;
            this.numMines = 99;
            initGame(this.row, this.col, this.numMines);
            System.out.println("RESTART EXPERT");
            firstClick = true;
        }));


        // clear and add buttons to grid
        buttons = new ArrayList<>();
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                System.out.println("Added");
                int finalR = r;
                int finalC = c;
                buttons.add(new ButtonCell(flag, this.row, this.col, r, c, this, () -> {
                    if (curState != -1) {
                        if (mouseButton == RIGHT) {
                            if (reveals[finalR][finalC]) return; // do nothing current cell is revealed

                            // 1. put flag on current cell
                            flags[finalR][finalC] = !flags[finalR][finalC];
                            if (flags[finalR][finalC] && mines[finalR][finalC] != 0) {
                                numFlags++;
                                minesLeft--;
                                if (numFlags == numMines) {
                                    curState = 1;
                                    stopTime = startTime / 1000;
                                }
                            } else if (!flags[finalR][finalC] && mines[finalR][finalC] != 0) {
                                minesLeft++;
                            }

                        } else if (mouseButton == LEFT) {
                            if (flags[finalR][finalC]) return; // do nothing if cur cell is FLAG

                            if (firstClick) {
                                firstClick = false;
                                do {
                                    data.clearMines();
                                    data.placeMines();
                                } while (data.calcNear(finalR, finalC) != 0);
                                startTime = System.currentTimeMillis();
//                                JOptionPane.showMessageDialog(null, Arrays.deepToString(this.mines));
                            }

                            if (mines[finalR][finalC] > 0) {
                                JOptionPane.showMessageDialog(null, "GameOver");
                                curState = -1;
                                stopTime = startTime / 1000;
                                startTime = 0;
                            } else {
                                data.reveal(finalR, finalC);
                            }
                        }
                    }
                }));
            }
        }

        // init Image class
        image = new Smiley(this, () -> {
            initGame(row, col, numMines);
        });

        // init Counter class
        counter = new Counter(this);
    }

    public static void main(String[] args) {
        PApplet.main("MinesweeperGUI.Main");
    }
}