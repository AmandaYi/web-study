package com.zhaozheyun.base;

class ObjectT extends Object1 {
    public ObjectT() {
//        super();
        String name = super.name;
        System.out.println(name);
        String name2 = super.name;
        System.out.println(name2);
    }

    public void init() {
        String name = super.name;
        System.out.println(name);
    }
}


public class Object2 {
    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) {
        new ObjectT();
    }
}
