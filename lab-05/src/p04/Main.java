package p04;

// LAMBDA EXPRESSIONS

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

        redButton.addActionListener((e) -> {
            mainPanel.setBackground(Color.RED);     // anonymous function | LAMBDA EXPRESSION |
        });
        greenButton.addActionListener((e) -> {
            mainPanel.setBackground(Color.GREEN);  // anonymous function
        });
        blueButton.addActionListener((e) -> {
            mainPanel.setBackground(Color.BLUE);   // anonymous function
        });
    }

    public static void main(String[] args) {

        Main frame = new Main();
        frame.setTitle("First GUI application");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(Main.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


}

