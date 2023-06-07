package com.zhaozheyun.multiplethread;

//用同步策略做死锁
public class dealLock {
    public static void main(String[] args) {
        final Object o1 = new Object();
        final Object o2 = new Object();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                System.out.println("T1线程执行开始");
                synchronized (o1) {
                    System.out.println("T1占用O1中！");
                    try {
                        System.out.println("T1线程等待1秒，让T2有足够的时间占用O2");
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("T1等待O2中！");
                    synchronized (o2) {
                        System.out.println("T1占用o2中！");
                    }
                }

                System.out.println("T1线程执行完毕");
            }
        };
        t1.start();
        Thread t2 = new Thread() {
            @Override
            public void run() {
                System.out.println("T2线程执行开始");
                synchronized (o2) {
                    System.out.println("T2占用O1中！");
                    try {
                        System.out.println("T2线程等待1秒，让T1有足够的时间占用O1");
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("T2等待O1中！");
                    synchronized (o1) {
                        System.out.println("T2占用o2中！");
                    }
                }
                System.out.println("T2线程执行完毕");
            }
        };
        t2.start();
    }
}
