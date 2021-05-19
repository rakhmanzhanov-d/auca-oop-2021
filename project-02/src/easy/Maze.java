package easy;

import java.util.ArrayList;

public class Maze {
    private char[][] data;
    private int robotRow, robotCol, width, height;
    private ArrayList<Paired> boxGoalList = new ArrayList<>();
    private ArrayList<Paired> boxRedList = new ArrayList<>();

    public Maze(char[][] level) {
        this.height = level.length;
        this.width = level[0].length;
        this.data = level;

        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                if (level[r][c] == '@') {
                    robotRow = r;
                    robotCol = c;
                } else if (level[r][c] == '.') {
                    Paired exitArr = new Paired(r, c);
                    boxGoalList.add(exitArr);
                } else if (level[r][c] == '$') {
                    Paired redBreakArr = new Paired(r, c);
                    boxRedList.add(redBreakArr);
                }
            }
        }

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public char getCurElement(int row, int col) {
        return data[row][col];
    }

    public int getRobotCol() {
        return robotCol;
    }

    public int getRobotRow() {
        return robotRow;
    }

    public ArrayList<Paired> getBoxGoalList() {
        return boxGoalList;
    }

    public ArrayList<Paired> getBoxRedList() {
        return boxRedList;
    }

    public void move(int dr, int dc) {
        int tRow = robotRow + dr;
        int tCol = robotCol + dc;

        if (data[tRow][tCol] == '@' || data[tRow][tCol] == '.' || data[tRow][tCol] == ' ') {
            data[tRow][tCol] = '@';
            data[robotRow][robotCol] = ' ';
            robotRow = tRow;
            robotCol = tCol;
        } else if (data[tRow][tCol] == '$') {
            int breakRow = tRow + dr;
            int breakCol = tCol + dc;
            if (data[breakRow][breakCol] == '@' || data[breakRow][breakCol] == '.' || data[breakRow][breakCol] == ' ') {
                data[tRow][tCol] = '@';
                data[robotRow][robotCol] = ' ';
                robotRow = tRow;
                robotCol = tCol;

                Paired newRedArr = new Paired(breakRow, breakCol);
                boxRedList.removeIf(el -> el.row == robotRow && el.col == robotCol);
                boxRedList.add(newRedArr);
                data[breakRow][breakCol] = '$';
            }
        }
    }

    public boolean isWin() {
        int cnt = 0;
        for (Paired goal : boxGoalList) {
            for (Paired redBreak : boxRedList) {
                if (goal.row == redBreak.row && goal.col == redBreak.col) {
                    cnt++;
                }
            }
        }

        return cnt == boxGoalList.size();
    }

    public char get(int r, int c) {
        return data[r][c];
    }

    class Paired {
        int row, col;

        public Paired(int row, int col) {
            this.col = col;
            this.row = row;
        }

        @Override
        public String toString() {
            return String.format("Paired(%d, %d)", row, col);
        }
    }
}

