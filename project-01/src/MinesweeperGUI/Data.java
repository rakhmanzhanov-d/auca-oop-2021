package MinesweeperGUI;

public class Data {
    private int row, col, numMines;
    private boolean[][] flags, reveals;
    private int[][] mines;
    private int[] dr;
    private int[] dc;
    private Main main;
    private boolean firstClick;

    Data(int row, int col, int numMines, Main main) {
        this.row = row;
        this.col = col;
        this.numMines = numMines;
        this.main = main;
        this.mines = new int[row][col];
        this.flags = new boolean[row][col];
        this.reveals = new boolean[row][col];
        this.dr = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
        this.dc = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
        this.firstClick = true;

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

    public boolean[][] getRevealsData() {
        return reveals;
    }

    public boolean[][] getFlagsData() {
        return flags;
    }

    private int calcNeighbour(int r, int c) {
        if (outBounds(r, c)) return 0;
        int cnt = 0;
        for (int neighbour = 0; neighbour < dr.length; neighbour++) {
            int tr = r + dr[neighbour];
            int tc = c + dc[neighbour];
            if (0 <= tr && tr < row && 0 <= tc && tc < col && mines[tr][tc] == -1) {
                cnt++;
            }
        }
        return cnt;
    }

    private boolean outBounds(int r, int c) {
        return r < 0 || c < 0 || r >= row || c >= col;
    }

    // Place mines on the grid
    public void placeMines() {
        int i = 0;
        while (i < numMines) {//We don't want mines to overlap, so while loop
            int x = (int) main.random(row);
            int y = (int) main.random(col);
            if (mines[x][y] == 1) continue;
            mines[x][y] = 1;
            i++;
        }
    }

    // clear mines form the grid
    public void clearMines() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                mines[i][j] = 0;
            }
        }
    }

    private void reveal(int r, int c) {
        if (outBounds(r, c)) return;
        if (reveals[r][c]) return;
        reveals[r][c] = true;
        if (calcNeighbour(r, c) != 0) return;
        for (int neighbour = 0; neighbour < dr.length; neighbour++) {
            reveal(r + dr[neighbour], c + dc[neighbour]);
        }
    }

    public void revealCurElement(int r, int c) {
        reveals[r][c] = true;
    }

    public int calcNear(int r, int c) {
        if (outBounds(r, c)) return 0;
        int cnt = 0;
        for (int i = 0; i < dr.length; i++) {
            for (int j = 0; j < dc.length; j++) {
                if (outBounds(r + i, c + j)) continue;
                cnt += mines[r + i][c + j];
            }
        }
        return cnt;
    }
}
