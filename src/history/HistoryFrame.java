package history;

import main.MainFrame;
import qustion.AnswerFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class HistoryFrame extends JFrame {
    private MainFrame mainFrame;
    public HistoryFrame(MainFrame mainFrame) {
        setTitle("履歴一覧");
        setSize(400,500);
        setLocationRelativeTo(null);

        JPanel p = new JPanel();
        JLabel l = new JLabel("<html><a href='file://C:/STUDY/enjoy/enjoyjava/src/qustion/AnswerListFrame.java'>4/17の解答</a></html>");
        //クリック可能かどうかの視認性
        l.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.mainFrame = mainFrame;

        l.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                mainFrame.setEnabled(true);
                new AnswerFrame();
//                try {
//                    Desktop.getDesktop().open(new File("C:/STUDY/enjoy/enjoyjava/src/qustion/AnswerListFrame.java"));
//                } catch (Exception ex) {
////                    ex.printStackTrace();
//                }
            }
        });
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeMainFrame();
            }
        });

        p.add(l);


        add(p);
        setVisible(true);
    }
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
                new AnswerFrame();
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
    private void closeMainFrame() {
        mainFrame.dispose(); // メイン画面を閉じる
    }
}
