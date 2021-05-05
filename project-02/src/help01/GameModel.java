package help01;

public class GameModel {
    private int curLevel;
    public Maze maze;
    static char[][][] levels = {
            {
                    {'#', '#', '#', '#', '#', '#', '#'},
                    {'#', ' ', ' ', ' ', ' ', ' ', '#'},
                    {'#', ' ', '#', 'E', '#', ' ', '#'},
                    {'#', ' ', '#', '#', '#', ' ', '#'},
                    {'#', ' ', ' ', 'R', '#', ' ', '#'},
                    {'#', ' ', '#', '#', '#', ' ', '#'},
                    {'#', ' ', ' ', ' ', ' ', ' ', '#'},
                    {'#', '#', '#', '#', '#', '#', '#'},

            },
            {
                    {'#', '#', '#', '#', '#', '#', '#'},
                    {'#', ' ', ' ', ' ', '#', 'E', '#'},
                    {'#', ' ', '#', ' ', '#', ' ', '#'},
                    {'#', ' ', '#', ' ', '#', ' ', '#'},
                    {'#', ' ', '#', ' ', ' ', ' ', '#'},
                    {'#', ' ', '#', ' ', '#', ' ', '#'},
                    {'#', 'R', '#', ' ', '#', ' ', '#'},
                    {'#', '#', '#', '#', '#', '#', '#'},

            },
            {
                    {'#', '#', '#', '#', '#'},
                    {'#', ' ', ' ', ' ', '#'},
                    {'#', ' ', '#', ' ', '#'},
                    {'#', ' ', '#', ' ', '#'},
                    {'#', ' ', '#', ' ', '#'},
                    {'#', ' ', '#', ' ', '#'},
                    {'#', 'R', '#', 'E', '#'},
                    {'#', '#', '#', '#', '#'},

            }
    };


    public GameModel() {
        this.curLevel = 0;
        maze = new Maze(levels[curLevel]);

    }

    public int getCurWidth() {
        return maze.getWidth();
    }

    public int getCurHeight() {
        return maze.getHeight();
    }

    public char getCurElement(int row, int col) {
        return maze.getCurElement(row, col);
    }

    public void nextLevel() {
        curLevel++;
        if (curLevel == levels.length) {
            curLevel = 0;
        }

        maze = new Maze(levels[curLevel]);
    }

    public int getCurLevel() {
        return curLevel + 1;
    }
}
