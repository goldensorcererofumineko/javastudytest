package main;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public Main() {
        setTitle("JavaMain");
        setSize(300, 500);
        setLocationRelativeTo (null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel nameLabel = new JLabel("KAINUMA");
        namePanel.add(nameLabel);
        add(namePanel, BorderLayout.NORTH);

        JPanel textPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel textLabel = new JLabel("進捗状況");
        textPanel.add(textLabel);

        JPanel buttonPanel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton listButton = new JButton("JAVA問題");
        JPanel buttonPanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton logButton = new JButton("履歴");
        buttonPanel1.add(listButton);
        buttonPanel2.add(logButton);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3, 0, 10, 10));

        centerPanel.add(textPanel);
        centerPanel.add(buttonPanel1);
        centerPanel.add(buttonPanel2);
        add(centerPanel, BorderLayout.CENTER);

        JPanel lowPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        add(lowPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
