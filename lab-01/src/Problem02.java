import java.util.Scanner;

public class Problem02 {
    static final int CANVAS_SIZE = 20;

    // direction
    static final int NORTH = 0;
    static final int EAST = 1;
    static final int SOUTH = 2;
    static final int WEST = 3;

    // main array
    static char[][] canvas = new char[CANVAS_SIZE][CANVAS_SIZE];

    // additional variables to move turtle
    static int turtleRow = 0;
    static int turtleCol = 0;
    static boolean turtlePenDown = false;
    static int turtleDir = EAST;
    static int numberOfSteps;
    static String userCmd;

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

    }
}
