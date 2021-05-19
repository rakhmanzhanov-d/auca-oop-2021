package easy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Main extends JFrame {
    static DrawPanel mainPanel;
    static JPanel commandPanel;
    static GameModel game;
    static Images images;
    static JLabel curLevel, counter;
    static int cnt = 0;

    Main() throws IOException {
        images = new Images();
        game = new GameModel();
        setLayout(new BorderLayout());
        commandPanel = new JPanel();
        cnt = 0;

        mainPanel = new DrawPanel();
        mainPanel.setBackground(Color.DARK_GRAY);
        mainPanel.setFocusable(true);
        mainPanel.requestFocus();
        add(mainPanel, BorderLayout.CENTER);

        mainPanel.addKeyListener(new CanvasPanelListener());

        JButton restart = new JButton("restart");
        JButton prevLevel = new JButton("<<");
        JButton nextLevel = new JButton(">>");
        restart.setFocusable(false);
        restart.setPreferredSize(new Dimension(100, 10));
        prevLevel.setFocusable(false);
        nextLevel.setFocusable(false);
        restart.setBackground(Color.CYAN);
        prevLevel.setBackground(Color.CYAN);
        nextLevel.setBackground(Color.CYAN);
        curLevel = new JLabel("restart game");
        counter = new JLabel(Integer.toString(cnt));

        restart.addActionListener((event) -> {
            cnt = 0;
            game.reset();
            curLevel.setText(Integer.toString(game.getCurLevel()));
            repaint();
        });

        nextLevel.addActionListener((e) -> {
            cnt = 0;
            game.nextLevel();
            curLevel.setText(Integer.toString(game.getCurLevel()));
            repaint();
        });

        prevLevel.addActionListener((e) -> {
            cnt = 0;
            game.prevLevel();
            curLevel.setText(Integer.toString(game.getCurLevel()));
            repaint();
        });

        // add command buttons
        curLevel.setOpaque(true);
        counter.setOpaque(true);
        curLevel.setFont(new Font("Serif", Font.PLAIN, 50));
        counter.setFont(new Font("Serif", Font.PLAIN, 50));
        curLevel.setHorizontalAlignment(SwingConstants.CENTER);
        counter.setHorizontalAlignment(SwingConstants.CENTER);

        commandPanel.add(curLevel, BorderLayout.CENTER);
        commandPanel.add(counter, BorderLayout.CENTER);
        commandPanel.add(restart, BorderLayout.NORTH);
        commandPanel.add(prevLevel, BorderLayout.NORTH);
        commandPanel.add(nextLevel, BorderLayout.NORTH);
        add(commandPanel, BorderLayout.EAST);
        commandPanel.setLayout(new GridLayout(0, 1));
        curLevel.setText(Integer.toString(game.getCurLevel()));
        counter.setText(Integer.toString(cnt));

        setTitle("YEAAAH");
        setSize(800, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        try {
            new Main();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    class DrawPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int widthCell = images.ground.getWidth();
            int heightCell = images.ground.getHeight();

            int xLeftUpper = getWidth() / 2 - widthCell * game.maze.getWidth() / 2;
            int yLeftUpper = getHeight() / 2 - heightCell * game.maze.getHeight() / 2;

            for (int r = 0; r < game.maze.getHeight(); r++) {
                for (int c = 0; c < game.maze.getWidth(); c++) {
                    switch (game.maze.get(r, c)) {
                        case ' ':
                            drawImage(g, images.ground, xLeftUpper + c * widthCell, yLeftUpper + r * heightCell, widthCell, heightCell);
                            break;
                        case '#':
                            drawImage(g, images.wall, xLeftUpper + c * widthCell, yLeftUpper + r * heightCell, widthCell, heightCell);
                            break;
                    }
                }
            }
            for (Maze.Paired goal : game.maze.getBoxGoalList()) {
                drawImage(g, images.ground, xLeftUpper + goal.col * widthCell, yLeftUpper + goal.row * heightCell, widthCell, heightCell);
                drawImage(g, images.goal, xLeftUpper + goal.col * widthCell, yLeftUpper + goal.row * heightCell, widthCell, heightCell);
            }

            for (Maze.Paired redBreak : game.maze.getBoxRedList()) {
                drawImage(g, images.boxRed, xLeftUpper + redBreak.col * widthCell, yLeftUpper + redBreak.row * heightCell, widthCell, heightCell);
            }
            drawImage(g, images.ground, xLeftUpper + game.maze.getRobotCol() * widthCell, yLeftUpper + game.maze.getRobotRow() * heightCell, widthCell, heightCell);
            drawImage(g, images.robot, xLeftUpper + game.maze.getRobotCol() * widthCell, yLeftUpper + game.maze.getRobotRow() * heightCell, widthCell, heightCell);
        }

        private void drawImage(Graphics g, BufferedImage img, int x, int y, int w, int h) {
            int leftX = x + w / 2 - img.getWidth() / 2;
            int topY = y + h / 2 - img.getHeight() / 2;
            g.drawImage(img, leftX, topY, null);
        }
    }

    private class CanvasPanelListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                JOptionPane.showMessageDialog(null, "Move your robot");
            } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                game.maze.move(-1, 0);
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                game.maze.move(1, 0);
                cnt++;
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                game.maze.move(0, -1);
                cnt++;
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                game.maze.move(0, 1);
                cnt++;
            }
            repaint();
            System.out.println(game.maze.getBoxRedList());
            System.out.println(game.maze.getRobotRow() + " row and " + game.maze.getRobotCol() + " cols");
            if (game.maze.isWin()) {
                JOptionPane.showMessageDialog(Main.this, String.format("Maze %d solved", game.getCurLevel()));
                game.nextLevel();
                cnt = 0;
                repaint();
            }


            curLevel.setText(Integer.toString(game.getCurLevel()));
            counter.setText(Integer.toString(cnt));
        }
    }
}
