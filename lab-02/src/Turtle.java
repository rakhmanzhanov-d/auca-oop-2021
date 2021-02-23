public class Turtle {
    public static final int NORTH = 0;
    public static final int EAST = 1;
    public static final int SOUTH = 2;
    public static final int WEST = 3;

    private Canvas canvas;
    private int row;
    private int col;
    private boolean isPenDown;
    private int dir;


    public Turtle(int aRow, int aCol, boolean penDown, int aDir) {
        row = aRow;
        col = aCol;
        isPenDown = penDown;
        dir = aDir;
    }

    public void turnLeft() {
        dir--;
        if (dir == -1) {
            dir = 3;
        }
    }

    public void turnRight() {
        dir = (dir + 1) % 4;
    }

    public void penUp() {
        isPenDown = false;
    }

    public void penDown() {
        isPenDown = true;
    }
    public void isInCanvas(int turtleRow, int turtleCol){
        return ;
    }

    public void move(int nSteps) {
        for (int i = 0; i < nSteps; i++) {
            switch (dir) {
                case NORTH:
                    row--;
                    break;
                case EAST:
                    col++;
                    break;
                case SOUTH:
                    row++;
                    break;
                case WEST:
                    col--;
                    break;
            }

//            if (!isInCanvas(turtleRow, turtleCol)) {
//                throw new RuntimeException("Turtle size is outside of canvas : " + turtleRow + ", " + turtleCol);
//            }
//            if (turtlePenDown) {
//                canvas[turtleRow][turtleCol] = '*';
//            }
        }
    }
}