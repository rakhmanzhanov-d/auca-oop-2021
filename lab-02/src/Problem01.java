import java.awt.*;
import java.util.Scanner;

public class Problem01 {
    public static void main(String[] args) {
        // Encapsulation

//        Canvas canvas = new Canvas();
//        Turtle turtle = new Turtle(0, 0, false, Turtle.EAST);
//        turtle.penDown();
//        canvas.show();
        UserCommand cmd = new UserCommand("Move 10");
        System.out.println(cmd.getCommand());
        System.out.println(cmd.getNumOfSteps());
    }
}
