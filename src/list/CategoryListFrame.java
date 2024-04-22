package list;

import dao.CategoryDao;
import dao.QuestionDao;
import dto.CategoryDto;
import qustion.QuestionFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;


public class CategoryListFrame extends JFrame {
    public CategoryListFrame() {
        CategoryDao categoryDao = new CategoryDao();
        QuestionDao questionDao = new QuestionDao();
        List<CategoryDto> categoryDtoList = categoryDao.getCategoryList();
        int size = questionDao.getCategorySize();
        JPanel p = new JPanel(new GridLayout(size, 0));
        setTitle("問題リスト" + size);
        setSize(400,500);
        setLocationRelativeTo(null);



        JLabel l1 = new JLabel("<html><a href=''>データクラス</a></html>");
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        l1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        JPanel p1 = new JPanel();
        l1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new QuestionFrame(0,"0");
            }
        });
        JLabel l2 = new JLabel("<html><a href=''>条件分岐</a></html>");
        l2.setHorizontalAlignment(SwingConstants.CENTER);
        l2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        JPanel p2 = new JPanel();
        l2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new QuestionFrame(0,"1");
            }
        });
        JLabel l3 = new JLabel("<html><a href=''>ループ</a></html>");
        l3.setHorizontalAlignment(SwingConstants.CENTER);
        l3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        JPanel p3 = new JPanel();
        l3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new QuestionFrame(0,"2");
            }
        });
        JLabel l4 = new JLabel("<html><a href=''>ループ</a></html>");
        l4.setHorizontalAlignment(SwingConstants.CENTER);
        l4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        JPanel p4 = new JPanel();
        l4.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new QuestionFrame(0,"3");
            }
        });

        p1.setLayout(new BorderLayout());
        p2.setLayout(new BorderLayout());
        p3.setLayout(new BorderLayout());
        p4.setLayout(new BorderLayout());

        p1.add(l1,BorderLayout.CENTER);
        p2.add(l2,BorderLayout.CENTER);
        p3.add(l3,BorderLayout.CENTER);
        p4.add(l4,BorderLayout.CENTER);

        p.add(p1);
        p.add(p2);
        p.add(p3);
        p.add(p4);

        add(p);

        setVisible(true);
    }
    public static void main(String[] args) {
        new CategoryListFrame();
    }
}
