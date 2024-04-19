package list;

import javax.swing.*;
import java.awt.*;

public class CategoryList extends JFrame {
    public CategoryList() {
        JPanel p = new JPanel(new GridLayout(3, 1));
        setTitle("問題リスト");
        setSize(400,500);
        setLocationRelativeTo(null);

        JLabel l1 = new JLabel("<html><a href=''>データクラス</a></html>");
        l1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        JLabel l2 = new JLabel("<html><a href=''>条件分岐</a></html>");
        l2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        JLabel l3 = new JLabel("<html><a href=''>ループ</a></html>");
        l3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        p.add(l1);
        p.add(l2);
        p.add(l3);

        add(p);

        setVisible(true);
    }
    public static void main(String[] args) {
        new CategoryList();
    }
}
