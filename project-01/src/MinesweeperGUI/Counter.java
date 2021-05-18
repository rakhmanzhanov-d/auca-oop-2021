package MinesweeperGUI;

public class Counter {
    private Main main;
    private float x, y, w, h;
    private long curTime, secondsPassed;

    Counter(Main main) {
        this.main = main;
        this.w = 50;
        this.h = 50;
        this.x = main.width / 2f - main.row * 25 / 2f;
        this.y = main.height / 2f - main.col * 17;
        this.curTime = main.startTime;
        this.secondsPassed = curTime / 1000;
    }

    public void draw() {
        main.fill(255, 0, 0);
        main.textSize(20);
        main.text(main.minesLeft + ": left", x, y);

        curTime = System.currentTimeMillis() - main.startTime;
        if (main.startTime == 0) curTime = 0;
        secondsPassed = curTime / 1000;
        main.fill(0, 255, 0);
        main.text(String.format("%d seconds", secondsPassed), x + main.row * 25, y);
    }
}

