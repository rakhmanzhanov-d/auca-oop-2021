package help03;

import processing.core.PApplet;

public class CommandButton extends ProcessingButton {
    private String text;

    public CommandButton(Main main, float x, float y, float w, float h, String text, Actionable action) {
        super(main, x, y, w, h, action);
        this.text = text;
    }

    @Override
    public void draw() {
        super.draw();
        float xCenter = x + w / 2;
        float yCenter = y + h / 2;
        main.fill(255, 0, 0);
        main.textSize(20);
        main.textAlign(PApplet.CENTER);
        main.text(text, xCenter, yCenter);
    }
}
