package com.zhaozheyun.senior;


class TickSystem {
    static Integer tick = 100;

    public static Integer getTick() {
        return tick;
    }

    public static void setTick(Integer tick) {

            TickSystem.tick = tick;
    }

    static Integer havenTick = 0;

    public static void setHavenTick(Integer havenTick) {
            TickSystem.havenTick = havenTick;
    }

    public static Integer getHavenTick() {
        return havenTick;
    }
}

class UseSystem extends Thread implements Runnable {
    @Override
    public  void run() {
        if (TickSystem.getTick() > 0) {
            synchronized (UseSystem.class){
                TickSystem.setTick(TickSystem.getTick() - 1);
                TickSystem.setHavenTick(TickSystem.getHavenTick() + 1);
            }
        }
    }
}

public class ThreadSyncTest {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new UseSystem().start();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("剩余的票" + TickSystem.getTick());
        System.out.println("卖出的票" + TickSystem.getHavenTick());
    }
}
