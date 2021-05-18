package console;

public class Data {
    private final int row;
    private final int col;
    private final int numMines;
    private final boolean[][] flags;
    private final boolean[][] reveals;
    private final int[][] mines;
    private final int[] dr;
    private final int[] dc;

    Data(int row, int col, int numMines) {
        this.row = row;
        this.col = col;
        this.numMines = numMines;
        this.mines = new int[row][col];
        this.flags = new boolean[row][col];
        this.reveals = new boolean[row][col];
        this.dr = new int[]{-1, -1, 1, 1, -1, 1, 0, 0};
        this.dc = new int[]{-1, 1, -1, 1, 0, 0, -1, 1};

        // init data values
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                mines[r][c] = 0;
                flags[r][c] = false;
                reveals[r][c] = false;
            }
        }
    }


    public int[][] getMinesData() {
        return mines;
    }

    private boolean outBounds(int r, int c) {
        return r < 0 || c < 0 || r >= row || c >= col;
    }

    // clear mines form the grid
    public void clearMines() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                mines[i][j] = 0;
            }
        }
    }

    // Place mines on the grid
    public void placeMines() {
        int i = 0;
        while (i < numMines) {//We don't want mines to overlap, so while loop
            int x = (int) (Math.random() * row - 1);
            int y = (int) (Math.random() * col - 1);
            if (mines[x][y] == 1) continue;
            mines[x][y] = 1;
            i++;
        }
    }

    public int calcNear(int r, int c) {
        if (outBounds(r, c)) return 0;
        int cnt = 0;
        for (int neighbourR = -1; neighbourR <= 1; neighbourR++) {
            for (int neighbourC = -1; neighbourC <= 1; neighbourC++) {
                if (outBounds(neighbourR + r, neighbourC + c)) continue;
                cnt += mines[neighbourR + r][neighbourC + c];
            }
        }
        return cnt;
    }

    public void reveal(int r, int c) {
        if (outBounds(r, c)) return;
        if (reveals[r][c]) return;
        reveals[r][c] = true;
        if (calcNear(r, c) != 0) return;
        for (int neighbour = 0; neighbour < dr.length; neighbour++) {
            reveal(r + dr[neighbour], c + dc[neighbour]);
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (flags[r][c]) {
                    str.append("F");
                } else if (!flags[r][c] && reveals[r][c]) {
                    str.append(calcNear(r, c));
                } else {
                    str.append(".");
                }
                str.append(" ");
            }
            str.append("\n");
        }
        return str.toString();
    }

    public boolean[][] getRevealsData() {
        return reveals;
    }

    public boolean[][] getFlagsData() {
        return flags;
    }

    public String show() {
        StringBuilder str = new StringBuilder();
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (flags[r][c]) {
                    str.append("F");
                } else if (mines[r][c] == 1) {
                    str.append("*");
                } else {
                    str.append(calcNear(r, c));
                }
                str.append(" ");
            }
            str.append("\n");
        }
        return str.toString();
    }
}
