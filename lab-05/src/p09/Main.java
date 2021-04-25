package p09;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class Main extends JFrame {
    CanvasPanel mainPanel;
    GameModel game = new GameModel();

    // layout
    Main() {
        setLayout(new BorderLayout());

        mainPanel = new CanvasPanel();
        add(mainPanel, BorderLayout.CENTER);

        mainPanel.setFocusable(true);
        mainPanel.addKeyListener(new CanvasPanelListener());

    }

    public static void main(String[] args) {

        Main frame = new Main();
        frame.setTitle("Chessboard");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(Main.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    class CanvasPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            // chessboard
            int widthCell = getWidth() / 8;
            int heightCell = getHeight() / 8;

            for (int row = 0; row < 8; row++) {
                for (int col = 0; col < 8; col++) {
                    if ((col + row) % 2 == 1) {
                        g.setColor(Color.WHITE);
                    } else {
                        g.setColor(Color.DARK_GRAY);
                    }
                    g.fillRect(row * widthCell, col * heightCell, widthCell, heightCell);
                }
            }

            g.setColor(Color.RED);
            g.fillOval(game.getCol() * widthCell, game.getRow() * heightCell, widthCell, heightCell);
        }
    }

    class CanvasPanelListener extends KeyAdapter { // we are promising that we will implement it
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                JOptionPane.showMessageDialog(null, "Move your robot");
            } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                game.moveUp();
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                game.moveDown();
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                game.moveLeft();
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                game.moveRight();
            }
            repaint();
        }

    }
}
