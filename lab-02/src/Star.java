import processing.core.PApplet;

public class Star {
    private float x;
    private float y;
    private float radius;
    private float dx;
    private float dy;
    private float red;
    private float green;
    private float blue;
    private Project02 canvas;
    private float angle;
    private float dangle = canvas.random(0.05f, 2);

    //    Constructor
    public Star(float x, float y, float r, float dx, float dy, float red, float green, float blue, Project02 canvas) {
        if (r <= 0) {
            throw new RuntimeException("Star: negative radius");
        }
        this.x = x;
        this.y = y;
        this.radius = r;
        this.dx = dx;
        this.dy = dy;
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.canvas = canvas;
    }

    public void draw() {
        canvas.pushMatrix();
        canvas.translate(x, y);
        canvas.rotate(angle);
        for(int i = 0; i < 10; i++){
            canvas.rotate(2 * canvas.PI / 10);
            canvas.line(0, -radius, 0, radius);
        }
        canvas.popMatrix();
    }

    public void move() {
        if (x >= canvas.width) {
            x = canvas.width - 1;
            dx = -dx;
            dangle = -dangle;
        }
        if (x < 0) {
            x = 0;
            dx = -dx;
            dangle = -dangle;
        }
        if (y >= canvas.height) {
            y = canvas.height - 1;
            dy = -dy;
            dangle = -dangle;
        }
        if (y < 0) {
            y = 0;
            dy = -dy;
            dangle = -dangle;
        }
        x += dx;
        y += dy;
        angle += dangle;
    }
}
