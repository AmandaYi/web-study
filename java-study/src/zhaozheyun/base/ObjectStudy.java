package com.zhaozheyun.base;

import sun.awt.resources.awt;

public class ObjectStudy {
    public static void say(int... name) {
        for (int i = 0; i < name.length; i++) {
            System.out.println(name[i]);
        }
    }

    String name;

    public ObjectStudy() {
        this("1");
        awt.getBundle("12");

    }

    public ObjectStudy(String s) {
    }

    public static int say() {
        return 1;
    }

    public void s1() {
        System.out.println("S1");
//        this.s2();
    }

    public void s2() {
        System.out.println("S2");
//        this.s1();
    }


    public static void main(String[] args) {
//        new ObjectStudy().s1();


//        ObjectStudy.say("1","2","3");
        ObjectStudy.say(1, 2, 3, 4, 5);
        int[] arr = new int[10];

        char[] arr1 = new char[10];
        System.out.println(arr1); //地址值?
        System.out.println(arr);//地址值?
    }


}
