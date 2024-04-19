package history;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HistoryFrame extends JFrame {
    public HistoryFrame() {
        setTitle("履歴一覧");
        setSize(400,500);
        setLocationRelativeTo(null);

        JPanel p = new JPanel();
        JLabel l = new JLabel("<html><a href='file://C:/STUDY/enjoy/enjoyjava/src/qustion/AnswerListFrame.java'>4/17の解答</a></html>");
        //クリック可能かどうかの視認性
        l.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        l.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
//                setVisible(false);
//                new AnswerListFrame();
//                try {
//                    Desktop.getDesktop().open(new File("C:/STUDY/enjoy/enjoyjava/src/qustion/AnswerListFrame.java"));
//                } catch (Exception ex) {
////                    ex.printStackTrace();
//                }
            }
        });

        p.add(l);


        add(p);
        setVisible(true);
    }
    public static void main(String[] args) {
        new HistoryFrame();
    }
}
