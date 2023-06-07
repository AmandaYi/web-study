package com.zhaozheyun.base;

import java.util.Date;

public class ObjectTest {
    public static void main(String[] args) {
        ObjectTest t = new ObjectTest();

        Object o = new Object();

        System.out.println(o.hashCode());

        System.out.println(t.hashCode());

        System.out.println(o.equals(t));

        System.out.println(o.toString());

        System.out.println(o.getClass());

        System.out.println(t.getClass());

//        t.init();


        t.testToString();
    }

    public void testToString() {
        char[] arr = new char[]{'a', 'b', 'c'};
        System.out.println(arr);//
        int[] arr1 = new int[]{1, 2, 3};
        System.out.println(arr1);//
        double[] arr2 = new double[]{1.1, 2.2, 3.3};
        System.out.println(arr2);//


        Object o1 = true ? new Integer(1) : new Double(2.0);
        System.out.println(o1);// "1"

        Object o2;
        if (true)
            o2 = new Integer(1);
        else
            o2 = new Double(2.0);
        System.out.println(o2);//
    }

    public void init() {
        Date d1 = new Date();
        try {
            Thread.currentThread().sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Date d2 = new Date();
        System.out.println(d1.equals(d2));
        System.out.println("d1 = " + d1.toString() + "; d2 = " + d2.toString());


        String s = "1";

    }
}
