package login;

import main.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {

    public LoginFrame() {
        setTitle("LoginJava");
        setSize(250, 150);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3,2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //フレーム枠の変更の可否
        setResizable(false);

        JPanel mainPanel = new JPanel();

        JPanel p1 = new JPanel();
        JLabel l1 = new JLabel("ID");
        JTextField t1 = new JTextField(10);
        p1.add(l1);
        p1.add(t1);
        add(p1, BorderLayout.CENTER);

        JPanel p2 = new JPanel();
        JLabel l2 = new JLabel("PW");
        JPasswordField pw = new JPasswordField(10);
        p2.add(l2);
        p2.add(pw);
        add(p2, BorderLayout.CENTER);

        JButton submitButton = new JButton("login");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = t1.getText();
                char[] pwChars = pw.getPassword();
                String pw = new String(pwChars);

                if (id.equals("admin") && pw.equals("123")) {
                    JOptionPane.showMessageDialog(null,"success");
                    setVisible(false);
                    new Main();
                } else {
                    JOptionPane.showMessageDialog(null,"error");
                }
            }
        });
        JPanel p3 = new JPanel();
        p3.add(submitButton);
        mainPanel.add(p3, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}