package help03;

import processing.core.*;
// clone of Minesweeper with processing library
// Creating BUTTON

import javax.swing.*;
import java.util.ArrayList;

public class Main extends PApplet {
    ArrayList<ProcessingButton> buttons = new ArrayList<>();
    private float backgroundColor = 0;

    public void settings() {
        fullScreen();
    }

    public void setup() {
        buttons.add(new CommandButton(this, 100, 100, 200, 100, "Exit", () -> System.exit(0)));
        buttons.add(new CommandButton(this, 700, 100, 200, 100, "Change Background", () -> backgroundColor = random(255)));
        buttons.add(new ProcessingButton(this, 500, 500, 200, 300, () -> JOptionPane.showMessageDialog(null, "Hey Bro, It is working")));

    }

    public void draw() {
        background(backgroundColor);

        for (ProcessingButton button : buttons) {
            button.draw();
        }
    }

    public void mouseReleased() {
        for (ProcessingButton button : buttons) {
            if (button.contains(mouseX, mouseY)) {
                button.performAction();
            }
        }
    }

    public static void main(String[] args) {
        PApplet.main("help03.Main");
    }

}