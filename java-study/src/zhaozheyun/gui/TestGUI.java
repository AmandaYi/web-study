package com.zhaozheyun.gui;

import javax.swing.*;

public class TestGUI {

    public static void main(String[] args) {
        JFrame f = new JFrame("红警");
        f.setSize(400, 600);
        f.setLocation(200, 200);
        f.setLayout(null);
        JButton b = new JButton("一键秒对方基地修改器！");
        b.setBounds(50, 50, 250, 30);
//        b.setLocation(20, 20);
        f.add(b);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

    }


}
