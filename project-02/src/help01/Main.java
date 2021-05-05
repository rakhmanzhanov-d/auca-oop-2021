package help01;

import javax.naming.BinaryRefAddr;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
            int xLeftUpper = getWidth() / 4;
            int yLeftUpper = getHeight() / 4;
            int widthCell = Math.round(getWidth() / 2f / game.getCurWidth());
            int heightCell = Math.round(getHeight() / 2f / game.getCurHeight());

            for (int row = 0; row < game.maze.getHeight(); row++) {
                for (int col = 0; col < game.maze.getWidth(); col++) {
                    Color curColor = game.getCurElement(row, col) == '#' ? Color.DARK_GRAY : Color.GREEN;
                    g.setColor(curColor);
                    g.fillRect(xLeftUpper + col * widthCell, yLeftUpper + row * heightCell, widthCell, heightCell);
                    g.setColor(Color.BLACK);
                    g.drawRect(xLeftUpper + col * widthCell, yLeftUpper + row * heightCell, widthCell, heightCell);
                }
            }

            g.setColor(Color.YELLOW);
            g.fillOval(xLeftUpper + game.maze.getExitCol() * widthCell, yLeftUpper + game.maze.getExitRow() * heightCell, widthCell, heightCell);
            g.setColor(Color.RED);
            g.fillOval(xLeftUpper + game.maze.getRobotCol() * widthCell, yLeftUpper + game.maze.getRobotRow() * heightCell, widthCell, heightCell);
        }
    }

    class CanvasPanelListener extends KeyAdapter { // we are promising that we will implement it
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                JOptionPane.showMessageDialog(null, "Move your robot");
            } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                game.maze.move(-1, 0);
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                game.maze.move(1, 0);
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                game.maze.move(0, -1);
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                game.maze.move(0, 1);
            }
            repaint();
            if (game.maze.isWin()) {
                JOptionPane.showMessageDialog(Main.this, String.format("Maze %d solved", game.getCurLevel()));
                game.nextLevel();
                repaint();
            }
        }

    }
}
