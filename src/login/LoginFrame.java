package login;

import main.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {

    private final JTextField idField;
    private final JPasswordField pwField;

    public LoginFrame() {
        setTitle("LoginJava");
        setSize(250, 150);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3,2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
//        mainPanel.setLayout(new GridLayout(3, 1, 10, 10));

        JPanel p1 = new JPanel();
        JLabel l1 = new JLabel("ID");
        idField = new JTextField(10);
//        idField.setPreferredSize(new Dimension(200, 30));
        p1.add(l1);
        p1.add(idField);
        add(p1, BorderLayout.CENTER);
//        mainPanel.add(p1,BorderLayout.CENTER);

        JPanel p2 = new JPanel();
        JLabel l2 = new JLabel("PW");
        pwField = new JPasswordField(10);
//        pwField.setPreferredSize(new Dimension(200, 30));
        p2.add(l2);
        p2.add(pwField);
        add(p2, BorderLayout.CENTER);
//        mainPanel.add(p2);
//        mainPanel.add(p2,BorderLayout.CENTER);

        JButton submitButton = new JButton("login");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                char[] pwChars = pwField.getPassword();
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