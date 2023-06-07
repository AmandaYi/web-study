package com.zhaozheyun.multiplethread;

import com.zhaozheyun.charactor.Hero;

public class TestThread {

    public static void main(String[] args) throws InterruptedException {

        Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 616;
        gareen.damage = 50;

        Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 300;
        teemo.damage = 30;

        Hero bh = new Hero();
        bh.name = "赏金猎人";
        bh.hp = 500;
        bh.damage = 65;

        Hero leesin = new Hero();
        leesin.name = "盲僧";
        leesin.hp = 455;
        leesin.damage = 80;

//        KillThread killThread1 = new KillThread(gareen, teemo);
//        killThread1.start();
//        KillThread killThread2 = new KillThread(bh, leesin);
//        killThread2.start();

//        使用匿名类输出一个hi
        Thread t1 = new Thread() {
            @Override
            public void run() {
                int seconds = 10;
                while (seconds >= 0) {
                    seconds--;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.printf("度过了%d秒",seconds);
                }
                System.out.println("匿名多进程1！");
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                System.out.println("匿名多进程2！");
            }
        };
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
        try {
            // t1线程主动加入主线程了
            t1.join();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程结束");
    }

}