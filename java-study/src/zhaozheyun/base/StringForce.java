package com.zhaozheyun.base;

import java.util.ArrayList;

public class StringForce {
    public static void main(String[] args) {
        new StringForce().init();
    }

    public void init() {
        String source = "100.1";
        Double i = Double.parseDouble(source);
        System.out.println(i);

        short s = 5;
        s = (short) (s - 2);
        System.out.println(s);

        char c = '5';
        int e = 1;
        float d = .314f;
        double f = c;
        f = d;


        boolean x = true;
        boolean y = false;
        short z = 42;
        //if(y == true)
        if ((z++ == 42) && (y = true)) z++; // z = 44

        if ((x = false) || (++z == 45)) z++; // 45

        System.out.println("z=" + z); // 45

        int[] list = new int[2];
        list[0] = 0;
        list[1] = 1;
        ArrayList<Integer> list2 = new ArrayList(2);
        list2.add(1);
        list2.add(1);
        list2.add(1);
        list2.add(1);
        list2.add(1);


        String[] list3 = new String[2];
        System.out.println(list3[0]);


    }
}
