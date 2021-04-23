package p06;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
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

        mainPanel.addMouseMotionListener(new MouseMotionAdapter() {
            // 1. WE CAN ALSO CREATE ANONYMOUS CLASS AS A FUNCTION
            // 2. By using MouseMotionAdapter we can delete unnecessary methods from our class

            @Override
            public void mouseMoved(MouseEvent e) {
                setTitle(String.format("(%d, %d)", e.getX(), e.getY()));
            }

        });
    }

    public static void main(String[] args) {

        Main frame = new Main();
        frame.setTitle("Move mouse");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(Main.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
