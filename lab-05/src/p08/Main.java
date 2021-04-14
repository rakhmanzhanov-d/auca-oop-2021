package p08;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame {
    CanvasPanel mainPanel;

    // layout
    Main() {
        setLayout(new BorderLayout());
        mainPanel = new CanvasPanel();
        add(mainPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {

        Main frame = new Main();
        frame.setTitle("Chessboard");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(Main.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // CanvasPanel is a subclass of JPanel
    class CanvasPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            int widthCell = getWidth() / 8;
            int heightCell = getHeight() / 8;
            int x = 0, y = 0;
            for (int j = 0; j < 8; j++) {
                for (int i = 0; i < 8; i++) {
                    if ((i + 1) % 2 != j % 2) {
                        g.setColor(Color.BLACK);
                    } else {
                        g.setColor(Color.WHITE);
                    }
                    g.fillRect(i * widthCell, j * heightCell, widthCell, heightCell);
                }
            }
        }
    }
}
