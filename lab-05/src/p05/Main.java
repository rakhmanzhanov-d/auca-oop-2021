package p05;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

public class Main extends JFrame {
    JPanel mainPanel;

    // layout
    Main() {
        setLayout(new BorderLayout());

        mainPanel = new JPanel();
        mainPanel.setBackground(Color.DARK_GRAY);
        add(mainPanel, BorderLayout.CENTER);

        mainPanel.addMouseMotionListener(new PanelMouseMotionListener());
    }

    public static void main(String[] args) {

        Main frame = new Main();
        frame.setTitle("Move mouse");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(Main.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    class PanelMouseMotionListener implements MouseMotionListener {
        // we wrote implements to promise that we will implement required methods
        @Override
        public void mouseDragged(MouseEvent e) {

        }

        @Override
        public void mouseMoved(MouseEvent e) {
            setTitle(String.format("(%d, %d)", e.getX(), e.getY()));
        }

    }
}
