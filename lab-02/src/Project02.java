import processing.core.*;

import javax.swing.*;

public class Project02 extends PApplet {
    Star[] stars = new Star[100];

    public void settings() {
        fullScreen();
    }

    public void setup() {
        for (int i = 0; i < 100; i++) {
            stars[i] = new Star(random(width), random(height), random(10, 20), random(-10, 10), random(-10, 10), random(255), random(255), random(255), this);
        }
        frameRate(60);
    }

    public void draw() {
        background(0, 0, 0);
        for (int i = 0; i < stars.length; i++) {
            stars[i].draw();
            stars[i].move();

        }
    }

    public static void main(String[] args) {
        PApplet.main("Project02");
    }

}