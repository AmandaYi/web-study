package com.zhaozheyun.multiplethread;

public class Hero {
    String name;
    int hp;

    //    加血
    public synchronized void addHp() {
        System.out.println("加血" + hp);
        this.hp++;
        if (this.hp > 1) {
//            如果血量大于1了，那么就可以减少扣血
            System.out.println("如果血量大于1了，那么就可以减少扣血");
            this.notify();
        }
    }

    //    减血
    public synchronized void reduceHp() {
        System.out.println("减血" + this.hp);
        if (this.hp == 1) {
//            如果血量是1，就不能减少了，那么需要释放对象同步占用
            try {
                System.out.println(" 如果血量是1，就不能减少了，那么需要释放对象同步占用");
                this.wait();
            } catch (Exception e) {

            }
        }
        this.hp--;
    }
}
