package com.zhaozheyun.base;

interface InterfaceTest0 {
    public abstract void start();
}

interface InterfaceTest1 {
    public final Integer ID = 1;

    public abstract void start();

    public abstract void stop();
}

abstract class InterfaceClass {
    public final Integer ID = 1;

    public void start() {

    }
}


public class InterfaceTest extends InterfaceClass implements InterfaceTest0, InterfaceTest1 {
    public void stop() {
//        System.out.println(this.ID);
    }

    public static void main(String[] args) {
        new InterfaceTest().start();
    }

}


interface A {
    public final int x = 0;
}

class B {
    // int x = 1;
}

class C extends B implements A {
    public void print() {
        System.out.println(this.x);
    }

    public static void main(String[] args) {
        new C().print();
    }
}







