package qustion;

import dao.QuestionDao;
import dto.QuestionDto;
import main.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static javax.swing.JOptionPane.YES_OPTION;

public class QuestionFrame extends JFrame {
    JButton b2 = new JButton("提出");

    public QuestionFrame(int index, String cate) {
        b2.setEnabled(false);
        JPanel p = new JPanel(new GridLayout(4,1));

        JPanel p1 = new JPanel();

        QuestionDao questionDao = new QuestionDao();

        List<QuestionDto> questionDtoList = questionDao.getQuestionList(cate);



        JTextArea t1 = new JTextArea(10,30);
        t1.append(questionDtoList.get(index).getContent());

        JScrollPane scrollPane = new JScrollPane(t1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        p1.add(scrollPane);
        p.add(p1);

        int size = questionDtoList.size();

        setTitle("楽しいJAVA-LIST(" + (index+1) + "/" + size + ")");
        setSize(400,500);
        setLocationRelativeTo(null);

        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));

        String[] selectionArr = questionDtoList.get(index).getSelection().split(",");
        // 選択肢数
        JRadioButton[] radioArr = new JRadioButton[selectionArr.length];
        for(int i=0; i < selectionArr.length; i++) {
            radioArr[i] = new JRadioButton(selectionArr[i]);
            radioArr[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(index == questionDtoList.size()-1) {
                        b2.setEnabled(true);
                    }
                }
            });
        }

        ButtonGroup bg = new ButtonGroup();
        for(int i=0; i < selectionArr.length; i++) {
            bg.add(radioArr[i]);
        }

        for(int i=0; i < selectionArr.length; i++) {
            p2.add(radioArr[i]);
        }

        p.add(p2);

        JPanel p3 = new JPanel(new GridLayout(1,3));
        JButton b1 = new JButton("前");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new QuestionFrame(index -1,cate);
            }
        });
        // 見てるidx 0であれば、非活性
        if(index == 0) {
            b1.setEnabled(false);
        } else {
            b1.setEnabled(true);
        }


        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "お疲れ様です。メイン画面に戻ります。");
                setVisible(false);
                new MainFrame();
            }
        });

        // 見てるidxが最後であれば、非活性
        JButton b3 = new JButton("次");
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new QuestionFrame(index + 1,cate);
            }
        });
        if(index == questionDtoList.size()-1) {
            b3.setEnabled(false);
        } else {
            b3.setEnabled(true);
        }
        p3.add(b1);
        p3.add(b2);
        p3.add(b3);

        p.add(p3);

        JPanel p4 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton b4 = new JButton("テスト中断");
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "中断します。よろしいですか？", "確認" , 2);
                if(result == YES_OPTION) {
                    setVisible(false);
                    new MainFrame();
                }
            }
        });
        p4.add(b4);

        p.add(p4);


        add(p);
        setVisible(true);
    }

    public static void main(String[] args) {
        new QuestionFrame(1,"1");
    }
}