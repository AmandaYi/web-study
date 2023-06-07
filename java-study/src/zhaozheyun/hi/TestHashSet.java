package com.zhaozheyun.hi;

import com.zhaozheyun.charactor.Hero;

import java.util.HashMap;
import java.util.HashSet;

public class TestHashSet {


//    生成50个 0-9999之间的随机数，要求不能有重复的
    public static void main(String[] args) {
//        HashSet hash = new HashSet();
//        while (hash.size() < 50) {
//            int i = (int) (Math.random() * 10000);
//            if( i >= 0 && i <= 9999) {
//                hash.add(i);
//            }
//        }
//        System.out.println(hash);

        HashMap m1 = new HashMap();
        HashMap m2 = new HashMap();
        HashSet s1 = new HashSet();
        s1.add(m1);
        s1.add(m2);
        System.out.println(s1);
    }
}



