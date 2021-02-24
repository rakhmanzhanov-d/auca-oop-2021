import java.awt.*;
import java.util.Scanner;

public class Problem01 {
    static int numOfLine = 0;

    public static void main(String[] args) {

        try {
            run();
        } catch (RuntimeException e) {
            System.out.println("Your program has a problem in Line: " + numOfLine);
            System.out.println("\t" + e.getMessage());
        }
    }

    private static void run() {
        Scanner inp = new Scanner(System.in);
        Canvas canvas = new Canvas();
        Turtle turtle = new Turtle(canvas, 0, 0, false, Turtle.EAST);
        UserCommand cmd = new UserCommand(inp.nextLine());
        while (!cmd.equals(UserCommand.EXIT)) {
            ++numOfLine;
            switch (cmd.getCommand()) {
                case UserCommand.PEN_UP -> turtle.penUp();
                case UserCommand.PEN_DOWN -> turtle.penDown();
                case UserCommand.MOVE -> turtle.move(cmd.getNumOfSteps());
                case UserCommand.PRINT -> canvas.show();
                case UserCommand.TURN_LEFT -> turtle.turnLeft();
                case UserCommand.TURN_RIGHT -> turtle.turnRight();
            }
            cmd = new UserCommand(inp.nextLine());
        }
    }
}
