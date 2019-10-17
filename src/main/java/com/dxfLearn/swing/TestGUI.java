package com.dxfLearn.swing;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class TestGUI {
    public static void main(String[] args) {

        //region 测试
      /*
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(580, 200);
        f.setLayout(null);

        final JLabel l = new JLabel();

        ImageIcon i = new ImageIcon("C:\\Users\\lilij667\\Desktop\\git\\NIODemo\\src\\main\\java\\com\\dxfLearn\\swing\\pic\\shana.png");
        l.setIcon(i);
        l.setBounds(50, 50, i.getIconWidth(), i.getIconHeight());

        JButton b = new JButton("隐藏图片");
        b.setBounds(150, 200, 100, 30);

        // 给按钮 增加 监听
        b.addActionListener(new ActionListener() {

            // 当按钮被点击时，就会触发 ActionEvent事件
            // actionPerformed 方法就会被执行
            public void actionPerformed(ActionEvent e) {

                l.setVisible(false);
            }
        });

        f.add(l);
        f.add(b);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);
        */

      //endregion

        new TestGUI().getFrame();
    }


    public  JFrame createInfo(){

        JFrame frame = new JFrame("LOL");

        frame.setLocation(300,300);
        frame.setSize(300,300);
        frame.setLayout(null);

        return frame;
    }



    public  void getFrame(){


        JFrame frame = createInfo();

        runable(frame);

        closed(frame);
    }


    public void closed(JFrame frame){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }


    public void runable(JFrame frame){

        final JLabel label = new JLabel();
        ImageIcon i = new ImageIcon("C:\\Users\\lilij667\\Desktop\\git\\NIODemo\\src\\main\\java\\com\\dxfLearn\\swing\\pic\\shana.png");
        label.setIcon(i);
        label.setBounds(50, 50, i.getIconWidth(), i.getIconHeight());

        frame.add(label);

        label.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Random random = new Random();
                int x= random.nextInt(frame.getWidth() - label.getWidth());
                int y =random.nextInt(frame.getHeight()-label.getHeight());

                label.setLocation(x,y);


            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });







        frame.add(label);

    }
}