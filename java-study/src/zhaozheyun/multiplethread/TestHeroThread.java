package com.zhaozheyun.multiplethread;

public class TestHeroThread {
    public static void main(String[] args) {
        final Hero GaiLun = new Hero();
        GaiLun.hp = 10;

//        伤害
        Thread t1 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    GaiLun.reduceHp();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t1.start();
        Thread t2 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    GaiLun.addHp();
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t2.start();
    }
}
