package console;

import java.util.HashSet;
import java.util.Objects;

public class Game {
    private int row;
    private int col;
    private char[][] data;
    private char[][] curData;
    private int mines;
    private final String difficulty;
    private boolean isValid = true;
    private boolean winGame;
    private HashSet<Flag> flags = new HashSet<>();
    private int numOfMines;
    private int mineCnt;

    Game(int row, int col, int mines, String difficulty) {
        this.col = col;
        this.row = row;
        this.mines = mines;
        this.data = new char[row][col];
        this.curData = new char[row][col];
        this.difficulty = difficulty;
        this.numOfMines = 0;
        this.winGame = false;
        this.mineCnt = 0;

        data = initGameData();
    }

    public char[][] initGameData() {
        int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

        // 1. initialize data with prefilled values
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (Math.random() < ((mines * 100f) / (row * col)) / 100f) {
                    data[i][j] = '*';
                    numOfMines++;
                } else {
                    data[i][j] = '#';
                }
            }
        }
        // 2. Calculate neighbours according to mines
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (data[r][c] == '#') {
                    int cnt = 0;
                    for (int neighbour = 0; neighbour < dr.length; neighbour++) {
                        int tr = r + dr[neighbour];
                        int tc = c + dc[neighbour];
                        if (0 <= tr && tr < row && 0 <= tc && tc < col && data[tr][tc] == '*') {
                            cnt++;
                        }
                    }
                    data[r][c] = (char) (48 + cnt);
                }
            }
        }


        // initialize current data
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                curData[i][j] = '0';
            }
        }

        return data;
    }

    @Override
    public String toString() { // shows current data
        String header = String.format("Game Minesweeper(%s, %d rows, %d columns, %d mines)\n", difficulty, row, col, numOfMines);
        StringBuilder gameUI = new StringBuilder(header);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                gameUI.append(curData[i][j]);
            }
            gameUI.append("\n");
        }

        return gameUI.toString();
    }

    public String show() { // shows initial data
        StringBuilder curUI = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                curUI.append(data[i][j]);
            }
            curUI.append("\n");
        }

        return curUI.toString();
    }

    public void left(int row, int col) {
        if (curData[row - 1][col - 1] == 'F') {
            curData[row - 1][col - 1] = 'F';
        } else if (data[row - 1][col - 1] == '*') {
            isValid = false;
            curData[row - 1][col - 1] = '*';
        } else {
            curData[row - 1][col - 1] = data[row - 1][col - 1];
        }
    }

    public boolean chekValidness() {
        return isValid;
    }

    public void right(int row, int col) {
        Flag flag = new Flag(row, col);
        if (flags.contains(flag)) {
            flags.remove(flag);
            curData[row - 1][col - 1] = '0';
            System.out.println("remove flag");
            mineCnt--;
        } else {
            flags.add(flag);
            curData[row - 1][col - 1] = 'F';
            System.out.println("add flag");
            mineCnt++;
        }

        // check if user won the game
        if (numOfMines == mineCnt) {
            winGame = true;
        }
    }

    public boolean wonGame() {
        return winGame;
    }


    public class Flag {
        private int row;
        private int col;

        Flag(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Flag flag = (Flag) o;
            return row == flag.row && col == flag.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }

        @Override
        public String toString() {
            return String.format("Flag(%d, %d)", row, col);
        }
    }
}

