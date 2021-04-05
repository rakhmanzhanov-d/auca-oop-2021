package p02;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame {
    JPanel mainPanel;
    JPanel controlPanel;

    JButton redButton = new JButton("Red");
    JButton greenButton = new JButton("Green");
    JButton blueButton = new JButton("Blue");

    // layout
    Main() {
        setLayout(new BorderLayout());

        mainPanel = new JPanel();
        mainPanel.setBackground(Color.RED);
        add(mainPanel, BorderLayout.CENTER);

        controlPanel = new JPanel();
        controlPanel.setBackground(Color.DARK_GRAY);
        controlPanel.add(redButton);
        controlPanel.add(greenButton);
        controlPanel.add(blueButton);
        add(controlPanel, BorderLayout.SOUTH);

        redButton.addActionListener(new EventListener(this, Color.RED));
        greenButton.addActionListener(new EventListener(this, Color.GREEN));
        blueButton.addActionListener(new EventListener(this, Color.BLUE));
    }

    public static void main(String[] args) {

        Main frame = new Main();
        frame.setTitle("First GUI application");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(Main.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class EventListener implements ActionListener{
    Main frame;
    Color color;
    public EventListener(Main frame, Color color) {
        this.frame = frame;
        this.color = color;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.mainPanel.setBackground(color);
    }
}
