package com.zhaozheyun.charactor;

public class APADHero extends Hero implements AD, AP {
    public APADHero(String name) {
        super(name);
    }

    public void physicAttack() {

    };
    public void magicAttack() {
        System.out.println("进行魔法攻击");
    }
}