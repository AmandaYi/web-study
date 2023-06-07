package com.zhaozheyun.multiplethread;

import com.zhaozheyun.charactor.Hero;

public class KillThread extends Thread{

    private Hero h1;
    private Hero h2;

    public KillThread(Hero h1, Hero h2){
        this.h1 = h1;
        this.h2 = h2;
    }

    public void run(){
        while(!h2.isDead()){
            System.out.println(this.h2.name + "攻击中" + this.h1.name + "hp 减少中");
            h1.attackHero(h2);
        }
    }
}