package com.zhaozheyun.senior;

public class ThreadTest extends Thread {

    @Override
    public void run() {
        super.run();
        System.out.println("run了");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10000000; i++) {
            new ThreadTest().start();
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ThreadTest00 extends Thread {
    private String threadNAme;

    public ThreadTest00(String threadNAme) {
        this.threadNAme = threadNAme;
    }

    @Override
    public void run() {
        System.out.println("我是" + this.threadNAme + "创建的线程");
        ThreadTest2.setM(ThreadTest2.getM() - 2000);
        System.out.println(ThreadTest2.getM());
    }
}

//创建两个分线程，让其中一个线程输出1-100之间的偶数，另一
//        个线程输出1-100之间的奇数。
class ThreadTest0 extends Thread {
    private String threadNAme;

    public ThreadTest0(String threadNAme) {
        this.threadNAme = threadNAme;
    }

    @Override
    public void run() {
        new ThreadTest00(this.threadNAme).start();

//        int x = 100;
//        while (x >= 0) {
//            System.out.println(this.threadNAme + ((Integer) x).toString());
//            x--;
//        }
    }
}

class ThreadTest2 {
    private static Integer m = 3000;

    public static Integer getM() {
        return m;
    }

    public static void setM(Integer m) {
        ThreadTest2.m = m;
    }

    public static void main(String[] args) {
            ThreadTest0 t1 = new ThreadTest0("线程一");
            t1.start();
            ThreadTest0 t2 = new ThreadTest0("线程二");
            t2.start();


    }
}