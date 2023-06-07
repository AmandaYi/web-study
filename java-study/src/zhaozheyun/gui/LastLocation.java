package com.zhaozheyun.gui;

import javax.swing.*;
import java.io.*;
import java.util.HashMap;

public class LastLocation {
    JFrame f = null;
    String filename = "D:\\project\\src\\baby8013.com\\study\\java-study\\src\\com\\zhaozheyun\\gui\\location.txt";

    public LastLocation() {
        f = new JFrame("红警");
        this.init();
    }

    public void init() {
        HashMap m = this.getLocation();
        f.setSize(100, 400);
        System.out.println(m.get("width") + "@" +  m.get("height"));
        f.setLocation(( new Double((Double) m.get("width")).intValue()), new Double((Double) m.get("height")).intValue());
        f.setLayout(null);
        LastLocationWithSync lastLocationWithSync = new LastLocationWithSync(f);

        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lastLocationWithSync.start();
    }
    private HashMap getLocation() {
        double x = 0;
        double y = 0;

        try {
            File f = new File("D:\\project\\src\\baby8013.com\\study\\java-study\\src\\com\\zhaozheyun\\gui\\location.txt");
            FileInputStream fis  = new FileInputStream(f);
            DataInputStream dis = new DataInputStream(fis);
             x = dis.readDouble();
             y = dis.readDouble();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        HashMap<String, Double> m = new HashMap<String, Double>();
        m.put("width", x);
        m.put("height", y);
        return m;
    }

    public static void main(String[] args) {
        new LastLocation();
    }
}

class LastLocationWithSync extends Thread {
    double x;
    double y;
    JFrame f;
    public LastLocationWithSync(JFrame f) {

      this.f = f;
    }
    private void save(double x, double y) {
        x = f.getX();
        y = f.getY();

        try {
            File f = new File("D:\\project\\src\\baby8013.com\\study\\java-study\\src\\com\\zhaozheyun\\gui\\location.txt");
            FileOutputStream fos = new FileOutputStream(f);
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeDouble(x);
            dos.writeDouble(y);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        while (true) {
            try {
                this.save(x, y);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
