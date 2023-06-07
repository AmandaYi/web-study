package com.zhaozheyun.charactor;

import com.zhaozheyun.property.Item;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestCollection {
    public static void main (String[] args) {
//        ArrayList heros = new ArrayList();
//        heros.add(new Hero("盖伦"));
//        heros.add(new Hero("盖伦"));
//        heros.add(new Hero("盖伦"));
//        heros.add(new Hero("盖伦"));
//        heros.add(new Hero("盖伦"));

//      List hero = new HeroItemList();
//        for(int i = 0; i < 5; i++) {
//            hero.add(new Hero("盖伦" + i));
//        }
//
//        for(int i = 0; i < hero.size(); i++) {
//            System.out.println(hero.get(i));
//        }
//        比较 ArrayList和LinkedList 在最后面插入100000条数据，谁快谁慢？为什么？
        List aList = new ArrayList();
        List lList = new LinkedList();
        for( int i = 0; i < 5000; i ++) {
            aList.add(i);
            lList.add(i);
        }

        //   在后面插入数据
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < 10000000; i++) {
            aList.add(i);
        }
        long endTime = System.currentTimeMillis();
        long diffTime = endTime - startTime;
        System.out.printf("使用ArrayList在最后插入100000条数据，需要时间%d毫秒\n", diffTime);
        startTime = System.currentTimeMillis();
        for(int i = 0; i < 10000000; i++) {
            lList.add(i);
        }
        endTime = System.currentTimeMillis();
        diffTime = endTime - startTime;
        System.out.printf("使用LinkedList在最后插入100000条数据，需要时间%d毫秒\n", diffTime);

    }
}
