package com.zhaozheyun.base;

import java.util.Collection;

//抽象类
abstract class AbstractPerson {
    public abstract void welcome();


    public void say() {
    }

    AbstractPerson() {
    }

};

abstract class AbstractChinese extends AbstractPerson {
    @Override
    public void welcome() {

    }

    public abstract void welcome2();

    @Override
    public void say() {
        super.say();
    }
}

class HeNanRen extends AbstractChinese {
    @Override
    public void welcome2() {

    }
}

public class AbstractTest {
    public static void main(String[] args) {
        new HeNanRen();

    }
}
